package com.noxfl.momiji.woodchipper.worker.productdetail;

import com.noxfl.momiji.woodchipper.model.schema.message.DetailPageType;

public interface SiteScraperFactory {

    public SiteScraper getSiteScraper(DetailPageType detailPageType);

}