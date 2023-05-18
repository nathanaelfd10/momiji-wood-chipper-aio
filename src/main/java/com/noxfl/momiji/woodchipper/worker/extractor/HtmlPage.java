package com.noxfl.momiji.woodchipper.worker.extractor;

import org.jsoup.nodes.Element;

public abstract class HtmlPage implements Extractor {

    protected boolean isElementExists(Element element, String cssPath) {
        return element.select(cssPath).size() > 0;
    }

    protected String getText(Element element, String cssPath) {
        return isElementExists(element, cssPath) ? element.select(cssPath).text() : null;
    }

    protected String getAttribute(Element element, String cssPath, String attribute) {
        return isElementExists(element, cssPath) ? element.select(cssPath).attr(attribute) : null;
    }

}
