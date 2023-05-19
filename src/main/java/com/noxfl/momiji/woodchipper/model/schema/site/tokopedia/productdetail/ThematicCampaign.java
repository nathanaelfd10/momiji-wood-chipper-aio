
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
    "additionalInfo",
    "background",
    "campaignName",
    "icon",
    "__typename"
})
@Generated("jsonschema2pojo")
public class ThematicCampaign {

    @JsonProperty("additionalInfo")
    private String additionalInfo;
    @JsonProperty("background")
    private String background;
    @JsonProperty("campaignName")
    private String campaignName;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThematicCampaign() {
    }

    /**
     * 
     * @param background
     * @param additionalInfo
     * @param icon
     * @param campaignName
     * @param typename
     */
    public ThematicCampaign(String additionalInfo, String background, String campaignName, String icon, String typename) {
        super();
        this.additionalInfo = additionalInfo;
        this.background = background;
        this.campaignName = campaignName;
        this.icon = icon;
        this.typename = typename;
    }

    @JsonProperty("additionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @JsonProperty("additionalInfo")
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @JsonProperty("background")
    public String getBackground() {
        return background;
    }

    @JsonProperty("background")
    public void setBackground(String background) {
        this.background = background;
    }

    @JsonProperty("campaignName")
    public String getCampaignName() {
        return campaignName;
    }

    @JsonProperty("campaignName")
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
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
