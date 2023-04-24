package com.noxfl.momiji.woodchipper.worker.product.impl;

import com.noxfl.momiji.woodchipper.model.schema.message.DetailPageType;
import com.noxfl.momiji.woodchipper.worker.product.SiteScraper;
import com.noxfl.momiji.woodchipper.worker.product.SiteScraperFactory;
import com.noxfl.momiji.woodchipper.worker.product.tokopedia.TokopediaProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SiteScraperFactoryImpl implements SiteScraperFactory {

    private TokopediaProductDetail tokopediaProductDetail;

    @Autowired
    public void setTokopediaProductDetail(TokopediaProductDetail tokopediaProductDetail) {
        this.tokopediaProductDetail = tokopediaProductDetail;
    }

    @Override
    public SiteScraper getSiteScraper(DetailPageType detailPageType) {
        switch (detailPageType) {
            case TOKOPEDIA -> { return tokopediaProductDetail; }
            default -> throw new IllegalArgumentException("No DetailPageType found: " + detailPageType);
        }
    }
}
