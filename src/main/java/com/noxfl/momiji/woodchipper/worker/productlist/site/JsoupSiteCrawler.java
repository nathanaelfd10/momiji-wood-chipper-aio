package com.noxfl.momiji.woodchipper.worker.productlist.site;

import com.noxfl.momiji.woodchipper.model.schema.message.Content;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.Output;
import com.noxfl.momiji.woodchipper.worker.TargetUrlBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class JsoupSiteCrawler extends GenericSiteCrawler {

    private final String productsSelector;
    private final String productUrlSelector;
    private final String productUrlSelectorAttribute;

    public JsoupSiteCrawler(TargetUrlBuilder targetUrlBuilder, String productsSelector, String productUrlSelector, String productUrlSelectorAttribute) {
        super(targetUrlBuilder);
        this.productsSelector = productsSelector;
        this.productUrlSelector = productUrlSelector;
        this.productUrlSelectorAttribute = productUrlSelectorAttribute;
    }

    private List<Output> extractProductCards(List<Element> elements, boolean isSaveOrderOfAppearanceIndex) {

        List<Output> outputs = new ArrayList<>();

        for(int i=0; i < elements.size(); i++) {
            String productUrl = (productUrlSelectorAttribute.isBlank() || productUrlSelectorAttribute == null) ?
                    elements.get(i).select(productUrlSelector).text() :
                    elements.get(i).select(productUrlSelector).attr(productUrlSelectorAttribute);

            Output output = new Output();
            output.setProductUrl(productUrl);
            output.setRawContent(elements.get(i).toString());
            if(isSaveOrderOfAppearanceIndex) output.setOrderOfAppearanceIndex(i);

            outputs.add(output);
        }

        return outputs;
    }

    public List<Output> fetch(String url, boolean isSaveOrderOfAppearanceIndex) throws IOException {

        Document document = Jsoup.connect(url).get();

        List<Element> elements = document.select(productsSelector);

        return extractProductCards(elements, isSaveOrderOfAppearanceIndex);
    }

}
