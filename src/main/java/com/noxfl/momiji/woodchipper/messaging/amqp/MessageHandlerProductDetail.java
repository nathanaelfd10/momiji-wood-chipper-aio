package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.noxfl.momiji.woodchipper.model.schema.message.DetailPageType;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;
import com.noxfl.momiji.woodchipper.worker.productdetail.SiteScraperFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

public class MessageHandlerProductDetail extends MessageHandler {

    private SiteScraperFactory siteScraperFactory;
    private MessageSender messageSender;

    @Autowired
    public void setSiteCrawlerFactory(SiteScraperFactory siteScraperFactory, MessageSender messageSender) {
        this.siteScraperFactory = siteScraperFactory;
        this.messageSender = messageSender;
    }

    @Override
    protected void process(MomijiMessage momijiMessage) throws IOException, URISyntaxException, NoSuchFieldException {
        System.out.println("Received: " + momijiMessage.getJob().getContent().getOutput().getProductUrl());

        String detailPageType = momijiMessage.getJob().getSite().getName();
        String rawContent = siteScraperFactory.getSiteScraper(DetailPageType.valueOf(detailPageType)).fetchProduct(momijiMessage);
        momijiMessage.getJob().getContent().getOutput().setRawContent(rawContent);

        messageSender.send(momijiMessage);
    }

}
