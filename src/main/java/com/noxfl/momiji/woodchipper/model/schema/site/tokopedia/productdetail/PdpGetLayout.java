
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
    "requestID",
    "name",
    "pdpSession",
    "basicInfo",
    "components",
    "__typename"
})
@Generated("jsonschema2pojo")
public class PdpGetLayout {

    @JsonProperty("requestID")
    private String requestID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pdpSession")
    private String pdpSession;
    @JsonProperty("basicInfo")
    private BasicInfo basicInfo;
    @JsonProperty("components")
    private List<Component> components;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PdpGetLayout() {
    }

    /**
     * 
     * @param components
     * @param pdpSession
     * @param requestID
     * @param name
     * @param typename
     * @param basicInfo
     */
    public PdpGetLayout(String requestID, String name, String pdpSession, BasicInfo basicInfo, List<Component> components, String typename) {
        super();
        this.requestID = requestID;
        this.name = name;
        this.pdpSession = pdpSession;
        this.basicInfo = basicInfo;
        this.components = components;
        this.typename = typename;
    }

    @JsonProperty("requestID")
    public String getRequestID() {
        return requestID;
    }

    @JsonProperty("requestID")
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("pdpSession")
    public String getPdpSession() {
        return pdpSession;
    }

    @JsonProperty("pdpSession")
    public void setPdpSession(String pdpSession) {
        this.pdpSession = pdpSession;
    }

    @JsonProperty("basicInfo")
    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    @JsonProperty("basicInfo")
    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    @JsonProperty("components")
    public List<Component> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(List<Component> components) {
        this.components = components;
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
