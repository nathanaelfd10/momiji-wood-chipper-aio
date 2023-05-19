
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
    "useStock",
    "value",
    "stockWording",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Stock {

    @JsonProperty("useStock")
    private Boolean useStock;
    @JsonProperty("value")
    private String value;
    @JsonProperty("stockWording")
    private String stockWording;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stock() {
    }

    /**
     * 
     * @param useStock
     * @param stockWording
     * @param value
     * @param typename
     */
    public Stock(Boolean useStock, String value, String stockWording, String typename) {
        super();
        this.useStock = useStock;
        this.value = value;
        this.stockWording = stockWording;
        this.typename = typename;
    }

    @JsonProperty("useStock")
    public Boolean getUseStock() {
        return useStock;
    }

    @JsonProperty("useStock")
    public void setUseStock(Boolean useStock) {
        this.useStock = useStock;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("stockWording")
    public String getStockWording() {
        return stockWording;
    }

    @JsonProperty("stockWording")
    public void setStockWording(String stockWording) {
        this.stockWording = stockWording;
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
