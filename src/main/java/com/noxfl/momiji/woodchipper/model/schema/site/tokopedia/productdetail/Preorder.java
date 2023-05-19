
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
    "duration",
    "timeUnit",
    "isActive",
    "preorderInDays",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Preorder {

    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("timeUnit")
    private String timeUnit;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("preorderInDays")
    private Integer preorderInDays;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Preorder() {
    }

    /**
     * 
     * @param duration
     * @param preorderInDays
     * @param isActive
     * @param typename
     * @param timeUnit
     */
    public Preorder(Integer duration, String timeUnit, Boolean isActive, Integer preorderInDays, String typename) {
        super();
        this.duration = duration;
        this.timeUnit = timeUnit;
        this.isActive = isActive;
        this.preorderInDays = preorderInDays;
        this.typename = typename;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("timeUnit")
    public String getTimeUnit() {
        return timeUnit;
    }

    @JsonProperty("timeUnit")
    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("preorderInDays")
    public Integer getPreorderInDays() {
        return preorderInDays;
    }

    @JsonProperty("preorderInDays")
    public void setPreorderInDays(Integer preorderInDays) {
        this.preorderInDays = preorderInDays;
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
