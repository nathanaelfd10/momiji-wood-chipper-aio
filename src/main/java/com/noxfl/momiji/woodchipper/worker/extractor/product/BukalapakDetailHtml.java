package com.noxfl.momiji.woodchipper.worker.extractor.product;

import com.noxfl.momiji.woodchipper.worker.extractor.HtmlDetailPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class BukalapakDetailHtml extends HtmlDetailPage {

    @Override
    public HashMap<String, Object> extract(String content) {

        Element element = Jsoup.parse(content);

        HashMap<String, Object> data = new HashMap<>();

        data.put("name", getAttribute(element, "div[id=\"section-main-product\"] h1[title]", "title"));
        data.put("sold_count", getText(element, "div[id=\"section-main-product\"] c-main-product__reviews > span"));
        data.put("rating", element.select("div[id=\"section-main-product\"] .c-rating__bg ,c-rating__unit").size());
        data.put("max_rating", 5);
        data.put("price_original", getText(element, "div[id=\"section-main-product\"] .c-main-product__price .-stroke"));
        data.put("price", getText(element, "div[id=\"section-main-product\"] .c-main-product__price .-main"));
        data.put("stock", getText(element, ".u-txt--base"));
        data.put("store_url", getAttribute(element, ".c-seller__name a", "href"));
        data.put("store_name", getText(element, ".c-seller__header a"));
        data.put("store_location", getText(element, ".c-seller__city"));

        return data;
    }
}
