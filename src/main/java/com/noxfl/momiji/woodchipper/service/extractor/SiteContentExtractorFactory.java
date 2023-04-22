package com.noxfl.momiji.woodchipper.service.extractor;

import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;

public interface SiteContentExtractorFactory {

    public Extractor getContentExtractor(SiteContentType siteContentType);

}