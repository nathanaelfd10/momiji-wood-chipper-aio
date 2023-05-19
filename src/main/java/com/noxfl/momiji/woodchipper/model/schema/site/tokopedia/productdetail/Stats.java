
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
    "countView",
    "countReview",
    "countTalk",
    "rating",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Stats {

    @JsonProperty("countView")
    private String countView;
    @JsonProperty("countReview")
    private String countReview;
    @JsonProperty("countTalk")
    private String countTalk;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stats() {
    }

    /**
     * 
     * @param countReview
     * @param countView
     * @param rating
     * @param countTalk
     * @param typename
     */
    public Stats(String countView, String countReview, String countTalk, Integer rating, String typename) {
        super();
        this.countView = countView;
        this.countReview = countReview;
        this.countTalk = countTalk;
        this.rating = rating;
        this.typename = typename;
    }

    @JsonProperty("countView")
    public String getCountView() {
        return countView;
    }

    @JsonProperty("countView")
    public void setCountView(String countView) {
        this.countView = countView;
    }

    @JsonProperty("countReview")
    public String getCountReview() {
        return countReview;
    }

    @JsonProperty("countReview")
    public void setCountReview(String countReview) {
        this.countReview = countReview;
    }

    @JsonProperty("countTalk")
    public String getCountTalk() {
        return countTalk;
    }

    @JsonProperty("countTalk")
    public void setCountTalk(String countTalk) {
        this.countTalk = countTalk;
    }

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
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
