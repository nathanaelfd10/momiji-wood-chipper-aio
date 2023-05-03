package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxfl.momiji.woodchipper.messaging.cloudpubsub.MessagePublisher;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;
import com.noxfl.momiji.woodchipper.util.DateTimeUtils;
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

        String rawContent = momijiMessage.getJob().getContent().getOutput().getRawContent();

        HashMap<String, Object> outputFields = siteContentExtractorFactory.getContentExtractor(pageType).extract(rawContent);

        String timestamp = momijiMessage.getJob().getContent().getOutput().getTimestamp();
        if(timestamp == null || timestamp.isBlank()) {
            outputFields.put("timestamp", DateTimeUtils.getCurrentUtcDateTime());
            momijiMessage.getJob().getContent().getOutput().setTimestamp(timestamp);
        }

        // Functions for extra fields
        momijiMessage.getJob().getContent().getExtraContents().forEach(extraContent -> {
            outputFields.put(extraContent.getName(), extraContent.getContent());
        });

        String outputMessage = hashMapToJsonString(outputFields);

        System.out.println(outputMessage);

        messagePublisher.send(outputMessage);
    }
}
