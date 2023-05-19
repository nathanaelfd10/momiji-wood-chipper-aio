
package com.noxfl.momiji.woodchipper.model.schema.site.tokopedia.productdetail;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "campaignID",
    "campaignType",
    "campaignTypeName",
    "campaignIdentifier",
    "background",
    "percentageAmount",
    "originalPrice",
    "discountedPrice",
    "originalStock",
    "stock",
    "stockSoldPercentage",
    "threshold",
    "startDate",
    "endDate",
    "endDateUnix",
    "appLinks",
    "isAppsOnly",
    "isActive",
    "hideGimmick",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Campaign {

    @JsonProperty("campaignID")
    private String campaignID;
    @JsonProperty("campaignType")
    private String campaignType;
    @JsonProperty("campaignTypeName")
    private String campaignTypeName;
    @JsonProperty("campaignIdentifier")
    private Integer campaignIdentifier;
    @JsonProperty("background")
    private String background;
    @JsonProperty("percentageAmount")
    private Integer percentageAmount;
    @JsonProperty("originalPrice")
    private Integer originalPrice;
    @JsonProperty("discountedPrice")
    private Integer discountedPrice;
    @JsonProperty("originalStock")
    private Integer originalStock;
    @JsonProperty("stock")
    private Integer stock;
    @JsonProperty("stockSoldPercentage")
    private Integer stockSoldPercentage;
    @JsonProperty("threshold")
    private Integer threshold;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("endDateUnix")
    private String endDateUnix;
    @JsonProperty("appLinks")
    private String appLinks;
    @JsonProperty("isAppsOnly")
    private Boolean isAppsOnly;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("hideGimmick")
    private Boolean hideGimmick;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Campaign() {
    }

    /**
     * 
     * @param originalStock
     * @param campaignType
     * @param originalPrice
     * @param endDate
     * @param campaignID
     * @param threshold
     * @param endDateUnix
     * @param isActive
     * @param stockSoldPercentage
     * @param campaignTypeName
     * @param appLinks
     * @param discountedPrice
     * @param isAppsOnly
     * @param background
     * @param campaignIdentifier
     * @param hideGimmick
     * @param stock
     * @param percentageAmount
     * @param startDate
     * @param typename
     */
    public Campaign(String campaignID, String campaignType, String campaignTypeName, Integer campaignIdentifier, String background, Integer percentageAmount, Integer originalPrice, Integer discountedPrice, Integer originalStock, Integer stock, Integer stockSoldPercentage, Integer threshold, String startDate, String endDate, String endDateUnix, String appLinks, Boolean isAppsOnly, Boolean isActive, Boolean hideGimmick, String typename) {
        super();
        this.campaignID = campaignID;
        this.campaignType = campaignType;
        this.campaignTypeName = campaignTypeName;
        this.campaignIdentifier = campaignIdentifier;
        this.background = background;
        this.percentageAmount = percentageAmount;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
        this.originalStock = originalStock;
        this.stock = stock;
        this.stockSoldPercentage = stockSoldPercentage;
        this.threshold = threshold;
        this.startDate = startDate;
        this.endDate = endDate;
        this.endDateUnix = endDateUnix;
        this.appLinks = appLinks;
        this.isAppsOnly = isAppsOnly;
        this.isActive = isActive;
        this.hideGimmick = hideGimmick;
        this.typename = typename;
    }

    @JsonProperty("campaignID")
    public String getCampaignID() {
        return campaignID;
    }

    @JsonProperty("campaignID")
    public void setCampaignID(String campaignID) {
        this.campaignID = campaignID;
    }

    @JsonProperty("campaignType")
    public String getCampaignType() {
        return campaignType;
    }

    @JsonProperty("campaignType")
    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    @JsonProperty("campaignTypeName")
    public String getCampaignTypeName() {
        return campaignTypeName;
    }

    @JsonProperty("campaignTypeName")
    public void setCampaignTypeName(String campaignTypeName) {
        this.campaignTypeName = campaignTypeName;
    }

    @JsonProperty("campaignIdentifier")
    public Integer getCampaignIdentifier() {
        return campaignIdentifier;
    }

    @JsonProperty("campaignIdentifier")
    public void setCampaignIdentifier(Integer campaignIdentifier) {
        this.campaignIdentifier = campaignIdentifier;
    }

    @JsonProperty("background")
    public String getBackground() {
        return background;
    }

    @JsonProperty("background")
    public void setBackground(String background) {
        this.background = background;
    }

    @JsonProperty("percentageAmount")
    public Integer getPercentageAmount() {
        return percentageAmount;
    }

    @JsonProperty("percentageAmount")
    public void setPercentageAmount(Integer percentageAmount) {
        this.percentageAmount = percentageAmount;
    }

    @JsonProperty("originalPrice")
    public Integer getOriginalPrice() {
        return originalPrice;
    }

    @JsonProperty("originalPrice")
    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    @JsonProperty("discountedPrice")
    public Integer getDiscountedPrice() {
        return discountedPrice;
    }

    @JsonProperty("discountedPrice")
    public void setDiscountedPrice(Integer discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @JsonProperty("originalStock")
    public Integer getOriginalStock() {
        return originalStock;
    }

    @JsonProperty("originalStock")
    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    @JsonProperty("stock")
    public Integer getStock() {
        return stock;
    }

    @JsonProperty("stock")
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @JsonProperty("stockSoldPercentage")
    public Integer getStockSoldPercentage() {
        return stockSoldPercentage;
    }

    @JsonProperty("stockSoldPercentage")
    public void setStockSoldPercentage(Integer stockSoldPercentage) {
        this.stockSoldPercentage = stockSoldPercentage;
    }

    @JsonProperty("threshold")
    public Integer getThreshold() {
        return threshold;
    }

    @JsonProperty("threshold")
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("endDateUnix")
    public String getEndDateUnix() {
        return endDateUnix;
    }

    @JsonProperty("endDateUnix")
    public void setEndDateUnix(String endDateUnix) {
        this.endDateUnix = endDateUnix;
    }

    @JsonProperty("appLinks")
    public String getAppLinks() {
        return appLinks;
    }

    @JsonProperty("appLinks")
    public void setAppLinks(String appLinks) {
        this.appLinks = appLinks;
    }

    @JsonProperty("isAppsOnly")
    public Boolean getIsAppsOnly() {
        return isAppsOnly;
    }

    @JsonProperty("isAppsOnly")
    public void setIsAppsOnly(Boolean isAppsOnly) {
        this.isAppsOnly = isAppsOnly;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("hideGimmick")
    public Boolean getHideGimmick() {
        return hideGimmick;
    }

    @JsonProperty("hideGimmick")
    public void setHideGimmick(Boolean hideGimmick) {
        this.hideGimmick = hideGimmick;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return typename;
    }

    @JsonProperty("__typename")
    public void setTypename(String typename) {
        this.typename = typename;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
