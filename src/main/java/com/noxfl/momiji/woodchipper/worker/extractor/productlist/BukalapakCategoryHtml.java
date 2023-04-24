package com.noxfl.momiji.woodchipper.worker.extractor.productlist;

import com.noxfl.momiji.woodchipper.worker.extractor.Extractor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class BukalapakCategoryHtml implements Extractor {

    private boolean isElementExists(Element element, String cssPath) {
        return element.select(cssPath).size() > 0;
    }

    private String getText(Element element, String cssPath) {
        return isElementExists(element, cssPath) ? element.select(cssPath).text() : null;
    }

    private String getAttribute(Element element, String cssPath, String attribute) {
        return isElementExists(element, cssPath) ? element.select(cssPath).attr(attribute) : null;
    }

    @Override
    public HashMap<String, Object> extract(String content) {

        Element element = Jsoup.parse(content);

        HashMap<String, Object> outputs = new HashMap<>();

        outputs.put("url", getAttribute(element, ".bl-product-card__description-name > p > a", "href"));
        outputs.put("name", getText(element, ".bl-product-card__description-name > p > a"));
        outputs.put("price", getText(element, ".bl-product-card__description-price > p"));
        outputs.put("price_original", getText(element, ".bl-product-card__description-price-discount > span:nth-child(1)"));
        outputs.put("total_sold", getText(element, "p[data-test-sold-count]"));
        outputs.put("rating", getText(element, ".bl-product-card__description-rating-and-sold a"));
        outputs.put("seller_location", getText(element, ".bl-product-card__location"));
        outputs.put("seller_name", getText(element, ".bl-product-card__description-store a"));
        outputs.put("seller_url", getAttribute(element, ".bl-product-card__description-store a", "href"));

//        outputs.values().removeAll(Collections.singleton(null));

        return outputs;
    }
}
