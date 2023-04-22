package com.noxfl.momiji.woodchipper.service.extractor.impl;

import com.noxfl.momiji.woodchipper.service.extractor.Extractor;
import com.noxfl.momiji.woodchipper.service.extractor.SiteContentExtractorFactory;
import com.noxfl.momiji.woodchipper.service.extractor.productlist.BukalapakCategoryHtml;
import com.noxfl.momiji.woodchipper.service.extractor.productlist.TokopediaCategoryJson;
import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentExtractorFactoryImpl implements SiteContentExtractorFactory {

    private TokopediaCategoryJson tokopediaCategoryJson;

    @Autowired
    private void setTokopediaCategoryJson(TokopediaCategoryJson tokopediaCategoryJson) {
        this.tokopediaCategoryJson = tokopediaCategoryJson;
    }

    private BukalapakCategoryHtml bukalapakCategoryHtml;

    @Autowired
    private void setBukalapakCategoryHtml(BukalapakCategoryHtml bukalapakCategoryHtml) {
        this.bukalapakCategoryHtml = bukalapakCategoryHtml;
    }

    @Override
    public Extractor getContentExtractor(SiteContentType siteContentType) {
        switch (siteContentType) {
            case TOKOPEDIA_CATEGORY_JSON -> {
                return tokopediaCategoryJson;
            }

            case BUKALAPAK_CATEGORY_HTML -> {
                return bukalapakCategoryHtml;
            }

            default -> throw new IllegalArgumentException("No processing function available for content type: "
                    + siteContentType);
        }
    }

}
