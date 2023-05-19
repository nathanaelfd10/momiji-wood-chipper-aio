
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
    "id",
    "name",
    "breadcrumbURL",
    "isAdult",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Detail {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("breadcrumbURL")
    private String breadcrumbURL;
    @JsonProperty("isAdult")
    private Boolean isAdult;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Detail() {
    }

    /**
     * 
     * @param breadcrumbURL
     * @param name
     * @param id
     * @param isAdult
     * @param typename
     */
    public Detail(String id, String name, String breadcrumbURL, Boolean isAdult, String typename) {
        super();
        this.id = id;
        this.name = name;
        this.breadcrumbURL = breadcrumbURL;
        this.isAdult = isAdult;
        this.typename = typename;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("breadcrumbURL")
    public String getBreadcrumbURL() {
        return breadcrumbURL;
    }

    @JsonProperty("breadcrumbURL")
    public void setBreadcrumbURL(String breadcrumbURL) {
        this.breadcrumbURL = breadcrumbURL;
    }

    @JsonProperty("isAdult")
    public Boolean getIsAdult() {
        return isAdult;
    }

    @JsonProperty("isAdult")
    public void setIsAdult(Boolean isAdult) {
        this.isAdult = isAdult;
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
