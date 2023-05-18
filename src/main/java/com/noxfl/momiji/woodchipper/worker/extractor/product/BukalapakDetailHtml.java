package com.noxfl.momiji.woodchipper.worker.extractor.product;

import com.noxfl.momiji.woodchipper.worker.extractor.Extractor;
import com.noxfl.momiji.woodchipper.worker.extractor.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;

public class BukalapakDetailHtml extends HtmlPage {

    @Override
    public HashMap<String, Object> extract(String content) {

        Element element = Jsoup.parse(content);

        HashMap<String, Object> data = new HashMap<>();

        String sectionMainProductSelector = "div[id=\"section-main-product\"]";

        data.put("name", getAttribute(element, "div[id=\"section-main-product\"] h1[title]", "title"));
        data.put("sold_count", getText(element, "div[id=\"section-main-product\"] c-main-product__reviews > span"));
        data.put("rating", element.select("div[id=\"section-main-product\"] .c-rating__bg ,c-rating__unit").size());
        data.put("max_rating", 5);
        data.put("price_original", getText(element, "div[id=\"section-main-product\"] .c-main-product__price .-stroke"));
        data.put("price", getText(element, "div[id=\"section-main-product\"] .c-main-product__price .-main"));
        data.put("stock", getText(element, ".u-txt--base"));
        data.put("description", "");
        data.put("store_url", "");
        data.put("store_id", "");
        data.put("store_name", "");
        data.put("store_location", "");
        data.put("store_rating", "");
        data.put("store_badge", "");


        return data;
    }
}
