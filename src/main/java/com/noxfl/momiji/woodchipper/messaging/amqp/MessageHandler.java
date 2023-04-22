package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;
import com.noxfl.momiji.woodchipper.service.productlist.SiteCrawlerFactory;
import com.noxfl.momiji.woodchipper.model.schema.message.ContentType;
import com.noxfl.momiji.woodchipper.model.schema.message.Job;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.PageType;
import com.noxfl.momiji.woodchipper.util.HashUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Fernando Nathanael
 *
 */
@Component
public class MessageHandler {

    private SiteCrawlerFactory siteCrawlerFactory;

    @Autowired
    public void setSiteCrawlerFactory(SiteCrawlerFactory siteCrawlerFactory) {
        this.siteCrawlerFactory = siteCrawlerFactory;
    }

    private SiteContentType getSiteContentType(String siteName, PageType pageType, ContentType contentType) {
        // WARNING: Naming order is crucial.
        // The naming in this app is: siteName + pageType + contentType.
        String siteContentTypeString = Arrays.stream(new String[] { siteName, pageType.toString(), contentType.toString() })
                .map(String::toUpperCase)
                .collect(Collectors.joining("_"));

        return SiteContentType.valueOf(siteContentTypeString);
    }

    public void handle(String message) throws IOException, URISyntaxException {

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MomijiMessage momijiMessage = objectMapper.readValue(message, MomijiMessage.class);

        Job job = momijiMessage.getJob();

        System.out.println("Received job: " + momijiMessage.getJob().getName());

        SiteContentType pageType = getSiteContentType(
                job.getSite().getName(),
                job.getPageType(),
                job.getContentType()
        );

        String jobIdRaw = String.format("%s-%s%s", pageType, job.getName());
        String jobIdHash = DigestUtils.md5Hex(jobIdRaw).toUpperCase();

        momijiMessage.getJob().setJobId(jobIdHash);

        siteCrawlerFactory.getSiteCrawler(pageType).fetchProducts(momijiMessage);
    }

}
