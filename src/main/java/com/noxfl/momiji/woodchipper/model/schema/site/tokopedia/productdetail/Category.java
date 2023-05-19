
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
    "id",
    "name",
    "title",
    "breadcrumbURL",
    "isAdult",
    "isKyc",
    "minAge",
    "detail",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Category {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("title")
    private String title;
    @JsonProperty("breadcrumbURL")
    private String breadcrumbURL;
    @JsonProperty("isAdult")
    private Boolean isAdult;
    @JsonProperty("isKyc")
    private Boolean isKyc;
    @JsonProperty("minAge")
    private Integer minAge;
    @JsonProperty("detail")
    private List<Detail> detail;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category() {
    }

    /**
     * 
     * @param breadcrumbURL
     * @param isKyc
     * @param minAge
     * @param name
     * @param id
     * @param detail
     * @param title
     * @param isAdult
     * @param typename
     */
    public Category(String id, String name, String title, String breadcrumbURL, Boolean isAdult, Boolean isKyc, Integer minAge, List<Detail> detail, String typename) {
        super();
        this.id = id;
        this.name = name;
        this.title = title;
        this.breadcrumbURL = breadcrumbURL;
        this.isAdult = isAdult;
        this.isKyc = isKyc;
        this.minAge = minAge;
        this.detail = detail;
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

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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

    @JsonProperty("isKyc")
    public Boolean getIsKyc() {
        return isKyc;
    }

    @JsonProperty("isKyc")
    public void setIsKyc(Boolean isKyc) {
        this.isKyc = isKyc;
    }

    @JsonProperty("minAge")
    public Integer getMinAge() {
        return minAge;
    }

    @JsonProperty("minAge")
    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    @JsonProperty("detail")
    public List<Detail> getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    public void setDetail(List<Detail> detail) {
        this.detail = detail;
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
