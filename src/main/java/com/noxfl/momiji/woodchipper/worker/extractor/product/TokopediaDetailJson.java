package com.noxfl.momiji.woodchipper.worker.extractor.product;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxfl.momiji.woodchipper.model.schema.site.tokopedia.category.productcard.TokopediaCategoryProductCard;
import com.noxfl.momiji.woodchipper.model.schema.site.tokopedia.productdetail.Component;
import com.noxfl.momiji.woodchipper.model.schema.site.tokopedia.productdetail.Datum;
import com.noxfl.momiji.woodchipper.model.schema.site.tokopedia.productdetail.PdpGetLayout;
import com.noxfl.momiji.woodchipper.model.schema.site.tokopedia.productdetail.TokopediaProductDetail;
import com.noxfl.momiji.woodchipper.worker.extractor.Extractor;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Optional;

public class TokopediaDetailJson implements Extractor {
    @Override
    public HashMap<String, Object> extract(String content) {

        TokopediaProductDetail tokopediaProductDetail;

        try {
            tokopediaProductDetail = new ObjectMapper()
                    .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                    .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                    .readValue(content, TokopediaProductDetail.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        PdpGetLayout pdpGetLayout = tokopediaProductDetail.getData().getPdpGetLayout();

        Optional<Component> optProductContent = pdpGetLayout.getComponents().stream()
                .filter(component -> component.getName().equalsIgnoreCase("product_content")).findFirst();
        Component productContent = optProductContent.orElse(null);
        Datum productContentDatum = productContent != null && productContent.getData().size() > 0
                ? productContent.getData().get(0)
                : null;

        String storeName = pdpGetLayout.getBasicInfo().getShopName();
        String alias = pdpGetLayout.getBasicInfo().getAlias();

        HashMap<String, Object> outputFields = new HashMap<>();
        outputFields.put("url", String.format("https://www.tokopedia.com/%s/%s", storeName, alias));
        outputFields.put("name", pdpGetLayout.getName());
        if(productContentDatum != null) {
            outputFields.put("price", productContentDatum.getCampaign().getDiscountedPrice());
            outputFields.put("price_original", productContentDatum.getCampaign().getOriginalPrice());
            outputFields.put("is_official_store", productContentDatum.getIsOS());
        }
        outputFields.put("total_sold", pdpGetLayout.getBasicInfo().getTxStats().getCountSold());
        outputFields.put("rating", pdpGetLayout.getBasicInfo().getStats().getRating());
        outputFields.put("seller_id", pdpGetLayout.getBasicInfo().getId());
        outputFields.put("seller_url", String.format("https://www.tokopedia.com/%s", storeName));
        outputFields.put("seller_name", storeName);
//        outputFields.put("seller_location", tokopediaCategoryProductCard.getShop().getLocation());

        return outputFields;
    }
}
