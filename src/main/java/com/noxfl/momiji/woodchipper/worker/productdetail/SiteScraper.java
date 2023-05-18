package com.noxfl.momiji.woodchipper.worker.productdetail;

import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;

import java.io.IOException;
import java.net.URISyntaxException;

public interface SiteScraper {

    public String fetchProduct(MomijiMessage momijiMessage) throws NoSuchFieldException, IOException, URISyntaxException;

}
