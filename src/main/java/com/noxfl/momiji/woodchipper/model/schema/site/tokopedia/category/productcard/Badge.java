
package com.noxfl.momiji.woodchipper.model.schema.site.tokopedia.category.productcard;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageUrl",
    "show",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Badge {

    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("show")
    private boolean show;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Badge() {
    }

    /**
     * 
     * @param imageUrl
     * @param show
     * @param typename
     */
    public Badge(String imageUrl, boolean show, String typename) {
        super();
        this.imageUrl = imageUrl;
        this.show = show;
        this.typename = typename;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("show")
    public boolean isShow() {
        return show;
    }

    @JsonProperty("show")
    public void setShow(boolean show) {
        this.show = show;
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
