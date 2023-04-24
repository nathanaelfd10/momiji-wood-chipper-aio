package com.noxfl.momiji.woodchipper.worker.extractor;

import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;

public interface SiteContentExtractorFactory {

    public Extractor getContentExtractor(SiteContentType siteContentType);

}