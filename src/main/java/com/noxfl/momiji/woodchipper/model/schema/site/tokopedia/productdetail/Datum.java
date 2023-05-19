
package com.noxfl.momiji.woodchipper.model.schema.site.tokopedia.productdetail;

import java.util.LinkedHashMap;
import java.util.List;
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
    "media",
    "videos",
    "__typename",
    "name",
    "price",
    "campaign",
    "thematicCampaign",
    "stock",
    "variant",
    "wholesale",
    "isCashback",
    "isTradeIn",
    "isOS",
    "isPowerMerchant",
    "isWishlist",
    "isCOD",
    "preorder",
    "content",
    "icon",
    "title",
    "isApplink",
    "applink"
})
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("media")
    private List<Medium> media;
    @JsonProperty("videos")
    private List<Object> videos;
    @JsonProperty("__typename")
    private String typename;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("campaign")
    private Campaign campaign;
    @JsonProperty("thematicCampaign")
    private ThematicCampaign thematicCampaign;
    @JsonProperty("stock")
    private Stock stock;
    @JsonProperty("variant")
    private Variant variant;
    @JsonProperty("wholesale")
    private List<Object> wholesale;
    @JsonProperty("isCashback")
    private IsCashback isCashback;
    @JsonProperty("isTradeIn")
    private Boolean isTradeIn;
    @JsonProperty("isOS")
    private Boolean isOS;
    @JsonProperty("isPowerMerchant")
    private Boolean isPowerMerchant;
    @JsonProperty("isWishlist")
    private Boolean isWishlist;
    @JsonProperty("isCOD")
    private Boolean isCOD;
    @JsonProperty("preorder")
    private Preorder preorder;
    @JsonProperty("content")
    private List<Content> content;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("title")
    private String title;
    @JsonProperty("isApplink")
    private Boolean isApplink;
    @JsonProperty("applink")
    private String applink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param applink
     * @param icon
     * @param thematicCampaign
     * @param isCashback
     * @param videos
     * @param media
     * @param title
     * @param isTradeIn
     * @param content
     * @param isCOD
     * @param wholesale
     * @param isPowerMerchant
     * @param isWishlist
     * @param price
     * @param name
     * @param variant
     * @param isApplink
     * @param campaign
     * @param stock
     * @param typename
     * @param preorder
     * @param isOS
     */
    public Datum(List<Medium> media, List<Object> videos, String typename, String name, Price price, Campaign campaign, ThematicCampaign thematicCampaign, Stock stock, Variant variant, List<Object> wholesale, IsCashback isCashback, Boolean isTradeIn, Boolean isOS, Boolean isPowerMerchant, Boolean isWishlist, Boolean isCOD, Preorder preorder, List<Content> content, String icon, String title, Boolean isApplink, String applink) {
        super();
        this.media = media;
        this.videos = videos;
        this.typename = typename;
        this.name = name;
        this.price = price;
        this.campaign = campaign;
        this.thematicCampaign = thematicCampaign;
        this.stock = stock;
        this.variant = variant;
        this.wholesale = wholesale;
        this.isCashback = isCashback;
        this.isTradeIn = isTradeIn;
        this.isOS = isOS;
        this.isPowerMerchant = isPowerMerchant;
        this.isWishlist = isWishlist;
        this.isCOD = isCOD;
        this.preorder = preorder;
        this.content = content;
        this.icon = icon;
        this.title = title;
        this.isApplink = isApplink;
        this.applink = applink;
    }

    @JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    @JsonProperty("videos")
    public List<Object> getVideos() {
        return videos;
    }

    @JsonProperty("videos")
    public void setVideos(List<Object> videos) {
        this.videos = videos;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return typename;
    }

    @JsonProperty("__typename")
    public void setTypename(String typename) {
        this.typename = typename;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("campaign")
    public Campaign getCampaign() {
        return campaign;
    }

    @JsonProperty("campaign")
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @JsonProperty("thematicCampaign")
    public ThematicCampaign getThematicCampaign() {
        return thematicCampaign;
    }

    @JsonProperty("thematicCampaign")
    public void setThematicCampaign(ThematicCampaign thematicCampaign) {
        this.thematicCampaign = thematicCampaign;
    }

    @JsonProperty("stock")
    public Stock getStock() {
        return stock;
    }

    @JsonProperty("stock")
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @JsonProperty("variant")
    public Variant getVariant() {
        return variant;
    }

    @JsonProperty("variant")
    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    @JsonProperty("wholesale")
    public List<Object> getWholesale() {
        return wholesale;
    }

    @JsonProperty("wholesale")
    public void setWholesale(List<Object> wholesale) {
        this.wholesale = wholesale;
    }

    @JsonProperty("isCashback")
    public IsCashback getIsCashback() {
        return isCashback;
    }

    @JsonProperty("isCashback")
    public void setIsCashback(IsCashback isCashback) {
        this.isCashback = isCashback;
    }

    @JsonProperty("isTradeIn")
    public Boolean getIsTradeIn() {
        return isTradeIn;
    }

    @JsonProperty("isTradeIn")
    public void setIsTradeIn(Boolean isTradeIn) {
        this.isTradeIn = isTradeIn;
    }

    @JsonProperty("isOS")
    public Boolean getIsOS() {
        return isOS;
    }

    @JsonProperty("isOS")
    public void setIsOS(Boolean isOS) {
        this.isOS = isOS;
    }

    @JsonProperty("isPowerMerchant")
    public Boolean getIsPowerMerchant() {
        return isPowerMerchant;
    }

    @JsonProperty("isPowerMerchant")
    public void setIsPowerMerchant(Boolean isPowerMerchant) {
        this.isPowerMerchant = isPowerMerchant;
    }

    @JsonProperty("isWishlist")
    public Boolean getIsWishlist() {
        return isWishlist;
    }

    @JsonProperty("isWishlist")
    public void setIsWishlist(Boolean isWishlist) {
        this.isWishlist = isWishlist;
    }

    @JsonProperty("isCOD")
    public Boolean getIsCOD() {
        return isCOD;
    }

    @JsonProperty("isCOD")
    public void setIsCOD(Boolean isCOD) {
        this.isCOD = isCOD;
    }

    @JsonProperty("preorder")
    public Preorder getPreorder() {
        return preorder;
    }

    @JsonProperty("preorder")
    public void setPreorder(Preorder preorder) {
        this.preorder = preorder;
    }

    @JsonProperty("content")
    public List<Content> getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(List<Content> content) {
        this.content = content;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("isApplink")
    public Boolean getIsApplink() {
        return isApplink;
    }

    @JsonProperty("isApplink")
    public void setIsApplink(Boolean isApplink) {
        this.isApplink = isApplink;
    }

    @JsonProperty("applink")
    public String getApplink() {
        return applink;
    }

    @JsonProperty("applink")
    public void setApplink(String applink) {
        this.applink = applink;
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
