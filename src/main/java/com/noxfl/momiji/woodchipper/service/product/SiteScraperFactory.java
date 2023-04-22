package com.noxfl.momiji.woodchipper.service.product;

import com.noxfl.momiji.woodchipper.model.schema.message.DetailPageType;

public interface SiteScraperFactory {

    public SiteScraper getSiteScraper(DetailPageType detailPageType);

}