package com.noxfl.momiji.woodchipper.worker.productlist.site;

import com.noxfl.momiji.woodchipper.model.schema.SelectorMap;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.Output;
import com.noxfl.momiji.woodchipper.worker.TargetUrlBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupSiteCrawler extends GenericSiteCrawler {

    private final SelectorMap selectorMap;

    public JsoupSiteCrawler(SelectorMap selectorMap) {

        this.selectorMap = selectorMap;
    }

    private List<Output> extractProductCards(List<Element> elements, boolean isSaveOrderOfAppearanceIndex) {

        String productUrlSelector = selectorMap.getProductUrlSelector();
        String productUrlSelectorAttribute = selectorMap.getProductUrlSelectorAttribute();

        List<Output> outputs = new ArrayList<>();

        for(int i=0; i < elements.size(); i++) {
            String productUrl = (productUrlSelector.isBlank() ||
                    productUrlSelectorAttribute == null) ?
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

    public List<Output> fetch(MomijiMessage momijiMessage) throws IOException {

        String targetUrl = momijiMessage.getJob().getTargetUrl();
        boolean isSaveOrderOfAppearanceIndex = momijiMessage.getJob().isSaveOrderOfAppearanceIndex();

        Document document = Jsoup.connect(targetUrl).get();

        List<Element> elements = document.select(selectorMap.getProductsSelector());

        return extractProductCards(elements, isSaveOrderOfAppearanceIndex);
    }

}
