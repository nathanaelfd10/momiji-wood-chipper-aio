package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.noxfl.momiji.woodchipper.model.schema.message.DetailPageType;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.worker.product.SiteScraperFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

public class MessageHandlerProduct extends MessageHandler {

    private SiteScraperFactory siteScraperFactory;

    @Autowired
    public void setSiteCrawlerFactory(SiteScraperFactory siteScraperFactory) {
        this.siteScraperFactory = siteScraperFactory;
    }

    @Override
    protected void doWork(MomijiMessage momijiMessage) throws IOException, URISyntaxException, NoSuchFieldException {
        String pageType = getSiteContentTypeAsString(
                momijiMessage.getJob().getSite().getName(),
                momijiMessage.getJob().getPageType(),
                momijiMessage.getJob().getContentType()
        );

        siteScraperFactory.getSiteScraper(DetailPageType.valueOf(pageType)).fetchProduct(momijiMessage);
    }

}
