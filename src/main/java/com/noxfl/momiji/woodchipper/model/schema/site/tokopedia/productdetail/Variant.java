
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
    "isVariant",
    "parentID",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Variant {

    @JsonProperty("isVariant")
    private Boolean isVariant;
    @JsonProperty("parentID")
    private String parentID;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Variant() {
    }

    /**
     * 
     * @param isVariant
     * @param parentID
     * @param typename
     */
    public Variant(Boolean isVariant, String parentID, String typename) {
        super();
        this.isVariant = isVariant;
        this.parentID = parentID;
        this.typename = typename;
    }

    @JsonProperty("isVariant")
    public Boolean getIsVariant() {
        return isVariant;
    }

    @JsonProperty("isVariant")
    public void setIsVariant(Boolean isVariant) {
        this.isVariant = isVariant;
    }

    @JsonProperty("parentID")
    public String getParentID() {
        return parentID;
    }

    @JsonProperty("parentID")
    public void setParentID(String parentID) {
        this.parentID = parentID;
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
