package com.noxfl.momiji.woodchipper.worker.productdetail.impl;

import com.noxfl.momiji.woodchipper.model.schema.message.DetailPageType;
import com.noxfl.momiji.woodchipper.worker.productdetail.SiteScraper;
import com.noxfl.momiji.woodchipper.worker.productdetail.SiteScraperFactory;
import com.noxfl.momiji.woodchipper.worker.productdetail.bukalapak.BukalapakProductDetail;
import com.noxfl.momiji.woodchipper.worker.productdetail.tokopedia.TokopediaProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SiteScraperFactoryImpl implements SiteScraperFactory {

    private TokopediaProductDetail tokopediaProductDetail;

    @Autowired
    public void setTokopediaProductDetail(TokopediaProductDetail tokopediaProductDetail) {
        this.tokopediaProductDetail = tokopediaProductDetail;
    }

    private BukalapakProductDetail bukalapakProductDetail;

    @Autowired
    public void setBukalapakProductDetail(BukalapakProductDetail bukalapakProductDetail) {
        this.bukalapakProductDetail = bukalapakProductDetail;
    }

    @Override
    public SiteScraper getSiteScraper(DetailPageType detailPageType) {
        switch (detailPageType) {
            case TOKOPEDIA -> { return tokopediaProductDetail; }
            case BUKALAPAK -> { return bukalapakProductDetail; }
            default -> throw new IllegalArgumentException("No DetailPageType found: " + detailPageType);
        }
    }
}
