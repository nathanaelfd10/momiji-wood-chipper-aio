package com.noxfl.momiji.woodchipper.worker.productlist.site.bukalapak.category;

import com.noxfl.momiji.woodchipper.model.schema.message.Content;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.Output;
import com.noxfl.momiji.woodchipper.worker.productlist.site.JsoupSiteCrawler;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URISyntaxException;
import java.util.List;

public class NewBukalapakSiteCrawler extends JsoupSiteCrawler {

//    @Override
//    public List<Output> fetch(MomijiMessage momijiMessage) throws URISyntaxException {
//        String url = momijiMessage.getJob().getCategory().getUrl();
//
//        url = new URIBuilder(url).addParameter("page", String.valueOf(getCurrentPage()))
//                .build()
//                .toString();
//
//        System.out.println("Crawling page: " + url);
//
//        String productsSelector = ".te-product-card";
//        String productUrlSelector = "div.bl-thumbnail--slider a";
//        String productUrlSelectorAttribute = "href";
//        boolean isSaveOrderOfAppearanceIndex = true;
//
//        return fetch(momijiMessage.getJob().getCategory().getUrl(), productsSelector,
//                productUrlSelectorAttribute, productUrlSelectorAttribute, true);
//    }

}
