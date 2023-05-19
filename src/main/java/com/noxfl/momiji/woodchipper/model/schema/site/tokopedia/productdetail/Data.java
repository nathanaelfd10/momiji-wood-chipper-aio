
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
    "pdpGetLayout"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("pdpGetLayout")
    private PdpGetLayout pdpGetLayout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param pdpGetLayout
     */
    public Data(PdpGetLayout pdpGetLayout) {
        super();
        this.pdpGetLayout = pdpGetLayout;
    }

    @JsonProperty("pdpGetLayout")
    public PdpGetLayout getPdpGetLayout() {
        return pdpGetLayout;
    }

    @JsonProperty("pdpGetLayout")
    public void setPdpGetLayout(PdpGetLayout pdpGetLayout) {
        this.pdpGetLayout = pdpGetLayout;
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
