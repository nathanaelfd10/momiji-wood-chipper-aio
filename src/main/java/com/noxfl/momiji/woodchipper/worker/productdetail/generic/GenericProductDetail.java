package com.noxfl.momiji.woodchipper.worker.productdetail.generic;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageSender;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.worker.productdetail.SiteScraper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class GenericProductDetail implements SiteScraper {

    @Override
    public String fetchProduct(MomijiMessage momijiMessage) throws NoSuchFieldException, IOException, URISyntaxException {
        String productUrl = momijiMessage.getJob().getContent().getOutput().getProductUrl();
        if(productUrl.isBlank())
            throw new NoSuchFieldException("No Product URL found at current Momiji Message!");

        return fetchRawData(momijiMessage);
    }

    protected abstract String fetchRawData(MomijiMessage momijiMessage) throws IOException, URISyntaxException;

}
