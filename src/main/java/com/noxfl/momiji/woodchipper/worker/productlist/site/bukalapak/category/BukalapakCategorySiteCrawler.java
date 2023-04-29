package com.noxfl.momiji.woodchipper.worker.productlist.site.bukalapak.category;

import com.noxfl.momiji.woodchipper.model.schema.message.Output;
import com.noxfl.momiji.woodchipper.worker.productlist.site.bukalapak.BukalapakSiteCrawler;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
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
    protected List<Output> fetch() throws IOException, URISyntaxException {
        String targetUrl = new URIBuilder(this.targetUrl).addParameter("page", String.valueOf(getCurrentPage()))
                .build()
                .toString();


        Document document = Jsoup.connect(targetUrl).get();
        List<Element> elements = document.select(".te-product-card");

        return elements.stream().map(element -> {

            String productUrl = element.select("div.bl-thumbnail--slider a").attr("href");

            Output output = new Output();
            output.setProductUrl(productUrl);
            output.setRawContent(element.toString());

//            Content content = new Content();
//            content.setExtras(momijiMessage.getJob().getContent().getExtras());
//            content.setUrl(productUrl);
//            content.setProduct(element.toString());

            return output;

        }).toList();
    }
}
