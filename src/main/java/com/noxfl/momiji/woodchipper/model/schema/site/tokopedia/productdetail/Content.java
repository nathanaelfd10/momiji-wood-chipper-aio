
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
    "title",
    "subtitle",
    "applink",
    "showAtFront",
    "isAnnotation",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Content {

    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("applink")
    private String applink;
    @JsonProperty("showAtFront")
    private Boolean showAtFront;
    @JsonProperty("isAnnotation")
    private Boolean isAnnotation;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Content() {
    }

    /**
     * 
     * @param applink
     * @param isAnnotation
     * @param subtitle
     * @param showAtFront
     * @param title
     * @param typename
     */
    public Content(String title, String subtitle, String applink, Boolean showAtFront, Boolean isAnnotation, String typename) {
        super();
        this.title = title;
        this.subtitle = subtitle;
        this.applink = applink;
        this.showAtFront = showAtFront;
        this.isAnnotation = isAnnotation;
        this.typename = typename;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("applink")
    public String getApplink() {
        return applink;
    }

    @JsonProperty("applink")
    public void setApplink(String applink) {
        this.applink = applink;
    }

    @JsonProperty("showAtFront")
    public Boolean getShowAtFront() {
        return showAtFront;
    }

    @JsonProperty("showAtFront")
    public void setShowAtFront(Boolean showAtFront) {
        this.showAtFront = showAtFront;
    }

    @JsonProperty("isAnnotation")
    public Boolean getIsAnnotation() {
        return isAnnotation;
    }

    @JsonProperty("isAnnotation")
    public void setIsAnnotation(Boolean isAnnotation) {
        this.isAnnotation = isAnnotation;
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
