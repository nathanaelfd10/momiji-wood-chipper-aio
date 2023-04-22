package com.noxfl.momiji.woodchipper.service.productlist.site.bukalapak.category;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageSender;
import com.noxfl.momiji.woodchipper.model.schema.message.Content;
import com.noxfl.momiji.woodchipper.service.productlist.site.bukalapak.BukalapakSiteCrawler;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BukalapakCategorySiteCrawler extends BukalapakSiteCrawler {

    @Override
    protected List<Content> fetch(MomijiMessage momijiMessage) throws IOException, URISyntaxException {
        String url = momijiMessage.getJob().getCategory().getUrl();

        url = new URIBuilder(url).addParameter("page", String.valueOf(getCurrentPage()))
                .build()
                .toString();

        System.out.println("Crawling page: " + url);

        Document document = Jsoup.connect(url).get();
        List<Element> elements = document.select(".te-product-card");

        List<Content> output = new ArrayList<>();

        for(var element : elements) {

            String productUrl = element.select(".bl-thumbnail__slider > div > a").attr("href");

            Content content = momijiMessage.getJob().getContent();

            content.setUrl(productUrl);
            content.setProduct(element.toString());

            output.add(content);
        }

        return output;
    }

}
