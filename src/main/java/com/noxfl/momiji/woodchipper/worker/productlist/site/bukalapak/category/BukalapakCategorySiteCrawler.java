package com.noxfl.momiji.woodchipper.worker.productlist.site.bukalapak.category;

import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.Output;
import com.noxfl.momiji.woodchipper.worker.productlist.site.bukalapak.BukalapakSiteCrawler;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class BukalapakCategorySiteCrawler extends BukalapakSiteCrawler {

    @Override
    protected List<Output> fetch(MomijiMessage momijiMessage) throws IOException, URISyntaxException {
        String url = momijiMessage.getJob().getCategory().getUrl();

        url = new URIBuilder(url).addParameter("page", String.valueOf(getCurrentPage()))
                .build()
                .toString();

        System.out.println("Crawling page: " + url);

        Document document = Jsoup.connect(url).get();
        List<Element> elements = document.select(".te-product-card");

        return elements.stream().map(element -> {
            String productUrl = element.select("div.bl-thumbnail--slider a").attr("href");
            return new Output(productUrl, element.toString(), null);
        }).toList();

    }

}
