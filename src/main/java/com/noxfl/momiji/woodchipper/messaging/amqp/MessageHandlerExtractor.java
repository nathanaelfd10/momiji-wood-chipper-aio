package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxfl.momiji.woodchipper.messaging.cloudpubsub.MessagePublisher;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;
import com.noxfl.momiji.woodchipper.worker.extractor.SiteContentExtractorFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

public class MessageHandlerExtractor extends MessageHandler {

    public static final boolean IS_ADD_UTC_TIMESTAMP = true;

    private MessagePublisher messagePublisher;

    private SiteContentExtractorFactory siteContentExtractorFactory;

    @Autowired
    private void setSiteContentExtractorFactory(SiteContentExtractorFactory siteContentExtractorFactory, MessagePublisher messagePublisher) {
        this.siteContentExtractorFactory = siteContentExtractorFactory;
        this.messagePublisher = messagePublisher;
    }

    private String hashMapToJsonString(HashMap<String, Object> fields) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(fields);
    }

    private String getCurrentUtcDateTime(SimpleDateFormat simpleDateFormat) {
        Date currentUtcTime = Date.from(Instant.now());

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

        return simpleDateFormat.format(currentUtcTime);
    }

    @Override
    protected void doWork(MomijiMessage momijiMessage) throws IOException, URISyntaxException, NoSuchFieldException, ExecutionException, InterruptedException, ParseException {
        SiteContentType pageType = getSiteContentType(
                momijiMessage.getJob().getSite().getName(),
                momijiMessage.getJob().getPageType(),
                momijiMessage.getJob().getContentType()
        );

        String content = momijiMessage.getJob().getContent().getOutput().getRawContent();

        HashMap<String, Object> outputFields = siteContentExtractorFactory.getContentExtractor(pageType).extract(content);

        if(IS_ADD_UTC_TIMESTAMP) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            outputFields.put("timestamp", getCurrentUtcDateTime(sdf));
        }

        // Functions for extra fields
        momijiMessage.getJob().getContent().getExtraContents().forEach(extra -> {
            outputFields.put(extra.getName(), extra.getContent());
        });

        String outputMessage = hashMapToJsonString(outputFields);

        System.out.println(outputMessage);

        messagePublisher.send(outputMessage);
    }
}
