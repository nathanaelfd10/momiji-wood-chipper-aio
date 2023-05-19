
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
    "alias",
    "createdAt",
    "isQA",
    "id",
    "shopID",
    "shopName",
    "minOrder",
    "maxOrder",
    "weight",
    "weightUnit",
    "condition",
    "status",
    "url",
    "needPrescription",
    "catalogID",
    "isLeasing",
    "isBlacklisted",
    "menu",
    "category",
    "txStats",
    "stats",
    "__typename"
})
@Generated("jsonschema2pojo")
public class BasicInfo {

    @JsonProperty("alias")
    private String alias;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("isQA")
    private Boolean isQA;
    @JsonProperty("id")
    private String id;
    @JsonProperty("shopID")
    private String shopID;
    @JsonProperty("shopName")
    private String shopName;
    @JsonProperty("minOrder")
    private Integer minOrder;
    @JsonProperty("maxOrder")
    private Integer maxOrder;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("weightUnit")
    private String weightUnit;
    @JsonProperty("condition")
    private String condition;
    @JsonProperty("status")
    private String status;
    @JsonProperty("url")
    private String url;
    @JsonProperty("needPrescription")
    private Boolean needPrescription;
    @JsonProperty("catalogID")
    private String catalogID;
    @JsonProperty("isLeasing")
    private Boolean isLeasing;
    @JsonProperty("isBlacklisted")
    private Boolean isBlacklisted;
    @JsonProperty("menu")
    private Menu menu;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("txStats")
    private TxStats txStats;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BasicInfo() {
    }

    /**
     * 
     * @param shopName
     * @param weight
     * @param isQA
     * @param menu
     * @param minOrder
     * @param url
     * @param isBlacklisted
     * @param createdAt
     * @param condition
     * @param catalogID
     * @param isLeasing
     * @param stats
     * @param needPrescription
     * @param alias
     * @param maxOrder
     * @param id
     * @param shopID
     * @param txStats
     * @param category
     * @param typename
     * @param weightUnit
     * @param status
     */
    public BasicInfo(String alias, String createdAt, Boolean isQA, String id, String shopID, String shopName, Integer minOrder, Integer maxOrder, Integer weight, String weightUnit, String condition, String status, String url, Boolean needPrescription, String catalogID, Boolean isLeasing, Boolean isBlacklisted, Menu menu, Category category, TxStats txStats, Stats stats, String typename) {
        super();
        this.alias = alias;
        this.createdAt = createdAt;
        this.isQA = isQA;
        this.id = id;
        this.shopID = shopID;
        this.shopName = shopName;
        this.minOrder = minOrder;
        this.maxOrder = maxOrder;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.condition = condition;
        this.status = status;
        this.url = url;
        this.needPrescription = needPrescription;
        this.catalogID = catalogID;
        this.isLeasing = isLeasing;
        this.isBlacklisted = isBlacklisted;
        this.menu = menu;
        this.category = category;
        this.txStats = txStats;
        this.stats = stats;
        this.typename = typename;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("isQA")
    public Boolean getIsQA() {
        return isQA;
    }

    @JsonProperty("isQA")
    public void setIsQA(Boolean isQA) {
        this.isQA = isQA;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("shopID")
    public String getShopID() {
        return shopID;
    }

    @JsonProperty("shopID")
    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    @JsonProperty("shopName")
    public String getShopName() {
        return shopName;
    }

    @JsonProperty("shopName")
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @JsonProperty("minOrder")
    public Integer getMinOrder() {
        return minOrder;
    }

    @JsonProperty("minOrder")
    public void setMinOrder(Integer minOrder) {
        this.minOrder = minOrder;
    }

    @JsonProperty("maxOrder")
    public Integer getMaxOrder() {
        return maxOrder;
    }

    @JsonProperty("maxOrder")
    public void setMaxOrder(Integer maxOrder) {
        this.maxOrder = maxOrder;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonProperty("weightUnit")
    public String getWeightUnit() {
        return weightUnit;
    }

    @JsonProperty("weightUnit")
    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("needPrescription")
    public Boolean getNeedPrescription() {
        return needPrescription;
    }

    @JsonProperty("needPrescription")
    public void setNeedPrescription(Boolean needPrescription) {
        this.needPrescription = needPrescription;
    }

    @JsonProperty("catalogID")
    public String getCatalogID() {
        return catalogID;
    }

    @JsonProperty("catalogID")
    public void setCatalogID(String catalogID) {
        this.catalogID = catalogID;
    }

    @JsonProperty("isLeasing")
    public Boolean getIsLeasing() {
        return isLeasing;
    }

    @JsonProperty("isLeasing")
    public void setIsLeasing(Boolean isLeasing) {
        this.isLeasing = isLeasing;
    }

    @JsonProperty("isBlacklisted")
    public Boolean getIsBlacklisted() {
        return isBlacklisted;
    }

    @JsonProperty("isBlacklisted")
    public void setIsBlacklisted(Boolean isBlacklisted) {
        this.isBlacklisted = isBlacklisted;
    }

    @JsonProperty("menu")
    public Menu getMenu() {
        return menu;
    }

    @JsonProperty("menu")
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("txStats")
    public TxStats getTxStats() {
        return txStats;
    }

    @JsonProperty("txStats")
    public void setTxStats(TxStats txStats) {
        this.txStats = txStats;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
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
