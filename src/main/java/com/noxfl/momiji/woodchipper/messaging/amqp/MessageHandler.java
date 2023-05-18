package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxfl.momiji.woodchipper.model.schema.message.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author Fernando Nathanael
 *
 */
public abstract class MessageHandler {

    protected SiteContentType getSiteContentType(String siteName, PageType pageType, ContentType contentType) {
        // WARNING: Naming order is crucial.
        // The naming in this app is: siteName + pageType + contentType.
        String siteContentTypeString = Arrays.stream(new String[] { siteName, pageType.toString(), contentType.toString() })
                .map(String::toUpperCase)
                .collect(Collectors.joining("_"));

        return SiteContentType.valueOf(siteContentTypeString);
    }

    protected String getSiteContentTypeAsString(String siteName, PageType pageType, ContentType contentType) {
        // WARNING: Naming order is crucial.
        // The naming in this app is: siteName + pageType + contentType.
        return Arrays.stream(new String[] { siteName, pageType.toString(), contentType.toString() })
                .map(String::toUpperCase)
                .collect(Collectors.joining("_"));
    }

    public void handle(String message) throws IOException, URISyntaxException, NoSuchFieldException, ExecutionException, InterruptedException, ParseException {

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        MomijiMessage momijiMessage = objectMapper.readValue(message, MomijiMessage.class);

        Job job = momijiMessage.getJob();

        System.out.println("Received job: " + momijiMessage.getJob().getName());

        String pageType = getSiteContentTypeAsString(
                job.getSite().getName(),
                job.getPageType(),
                job.getContentType()
        );

        String jobIdRaw = String.format("%s-%s-%s", pageType, job.getName(), Instant.now());
        String jobIdHash = DigestUtils.md5Hex(jobIdRaw).toUpperCase();

        momijiMessage.getJob().setJobId(jobIdHash);

        process(momijiMessage);

    }

    protected abstract void process(MomijiMessage momijiMessage) throws IOException, URISyntaxException, NoSuchFieldException, ExecutionException, InterruptedException, ParseException;

}
