package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;
import com.noxfl.momiji.woodchipper.worker.productlist.SiteCrawler;
import com.noxfl.momiji.woodchipper.worker.productlist.SiteCrawlerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class MessageHandlerProductList extends MessageHandler {

    private SiteCrawlerFactory siteCrawlerFactory;

    @Autowired
    public void setSiteCrawlerFactory(SiteCrawlerFactory siteCrawlerFactory) {
        this.siteCrawlerFactory = siteCrawlerFactory;
    }

    @Override
    protected void doWork(MomijiMessage momijiMessage) throws IOException, URISyntaxException {
            SiteContentType pageType = getSiteContentType(
                    momijiMessage.getJob().getSite().getName(),
                    momijiMessage.getJob().getPageType(),
                    momijiMessage.getJob().getContentType()
            );

           siteCrawlerFactory.getSiteCrawler(pageType).fetchProducts(momijiMessage);
    }
}

