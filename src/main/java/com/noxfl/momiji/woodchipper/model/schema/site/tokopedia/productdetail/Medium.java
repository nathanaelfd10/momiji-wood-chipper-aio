
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
    "type",
    "urlOriginal",
    "urlThumbnail",
    "urlMaxRes",
    "videoUrl",
    "prefix",
    "suffix",
    "description",
    "variantOptionID",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Medium {

    @JsonProperty("type")
    private String type;
    @JsonProperty("urlOriginal")
    private String urlOriginal;
    @JsonProperty("urlThumbnail")
    private String urlThumbnail;
    @JsonProperty("urlMaxRes")
    private String urlMaxRes;
    @JsonProperty("videoUrl")
    private String videoUrl;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("suffix")
    private String suffix;
    @JsonProperty("description")
    private String description;
    @JsonProperty("variantOptionID")
    private String variantOptionID;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Medium() {
    }

    /**
     * 
     * @param videoUrl
     * @param urlOriginal
     * @param prefix
     * @param urlThumbnail
     * @param description
     * @param urlMaxRes
     * @param variantOptionID
     * @param type
     * @param suffix
     * @param typename
     */
    public Medium(String type, String urlOriginal, String urlThumbnail, String urlMaxRes, String videoUrl, String prefix, String suffix, String description, String variantOptionID, String typename) {
        super();
        this.type = type;
        this.urlOriginal = urlOriginal;
        this.urlThumbnail = urlThumbnail;
        this.urlMaxRes = urlMaxRes;
        this.videoUrl = videoUrl;
        this.prefix = prefix;
        this.suffix = suffix;
        this.description = description;
        this.variantOptionID = variantOptionID;
        this.typename = typename;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("urlOriginal")
    public String getUrlOriginal() {
        return urlOriginal;
    }

    @JsonProperty("urlOriginal")
    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    @JsonProperty("urlThumbnail")
    public String getUrlThumbnail() {
        return urlThumbnail;
    }

    @JsonProperty("urlThumbnail")
    public void setUrlThumbnail(String urlThumbnail) {
        this.urlThumbnail = urlThumbnail;
    }

    @JsonProperty("urlMaxRes")
    public String getUrlMaxRes() {
        return urlMaxRes;
    }

    @JsonProperty("urlMaxRes")
    public void setUrlMaxRes(String urlMaxRes) {
        this.urlMaxRes = urlMaxRes;
    }

    @JsonProperty("videoUrl")
    public String getVideoUrl() {
        return videoUrl;
    }

    @JsonProperty("videoUrl")
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @JsonProperty("suffix")
    public String getSuffix() {
        return suffix;
    }

    @JsonProperty("suffix")
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("variantOptionID")
    public String getVariantOptionID() {
        return variantOptionID;
    }

    @JsonProperty("variantOptionID")
    public void setVariantOptionID(String variantOptionID) {
        this.variantOptionID = variantOptionID;
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
