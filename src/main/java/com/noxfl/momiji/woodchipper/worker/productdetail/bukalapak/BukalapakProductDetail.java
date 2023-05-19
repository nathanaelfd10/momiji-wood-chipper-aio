package com.noxfl.momiji.woodchipper.worker.productdetail.bukalapak;

import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.worker.productdetail.SiteScraper;
import com.noxfl.momiji.woodchipper.worker.productdetail.generic.GenericSiteScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BukalapakProductDetail extends GenericSiteScraper implements SiteScraper {
    @Override
    protected String fetchRawData(MomijiMessage momijiMessage) throws IOException {
        String productUrl = momijiMessage.getJob().getContent().getOutput().getProductUrl();
        Document document = Jsoup.connect(productUrl).get();
        return document.select("div[id=\"product-details-page\"]").toString();
    }
}
