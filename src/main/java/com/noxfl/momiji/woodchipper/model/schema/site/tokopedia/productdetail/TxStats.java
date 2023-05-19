
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
    "transactionSuccess",
    "transactionReject",
    "countSold",
    "paymentVerified",
    "itemSoldFmt",
    "__typename"
})
@Generated("jsonschema2pojo")
public class TxStats {

    @JsonProperty("transactionSuccess")
    private String transactionSuccess;
    @JsonProperty("transactionReject")
    private String transactionReject;
    @JsonProperty("countSold")
    private String countSold;
    @JsonProperty("paymentVerified")
    private String paymentVerified;
    @JsonProperty("itemSoldFmt")
    private String itemSoldFmt;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TxStats() {
    }

    /**
     * 
     * @param paymentVerified
     * @param countSold
     * @param itemSoldFmt
     * @param transactionSuccess
     * @param transactionReject
     * @param typename
     */
    public TxStats(String transactionSuccess, String transactionReject, String countSold, String paymentVerified, String itemSoldFmt, String typename) {
        super();
        this.transactionSuccess = transactionSuccess;
        this.transactionReject = transactionReject;
        this.countSold = countSold;
        this.paymentVerified = paymentVerified;
        this.itemSoldFmt = itemSoldFmt;
        this.typename = typename;
    }

    @JsonProperty("transactionSuccess")
    public String getTransactionSuccess() {
        return transactionSuccess;
    }

    @JsonProperty("transactionSuccess")
    public void setTransactionSuccess(String transactionSuccess) {
        this.transactionSuccess = transactionSuccess;
    }

    @JsonProperty("transactionReject")
    public String getTransactionReject() {
        return transactionReject;
    }

    @JsonProperty("transactionReject")
    public void setTransactionReject(String transactionReject) {
        this.transactionReject = transactionReject;
    }

    @JsonProperty("countSold")
    public String getCountSold() {
        return countSold;
    }

    @JsonProperty("countSold")
    public void setCountSold(String countSold) {
        this.countSold = countSold;
    }

    @JsonProperty("paymentVerified")
    public String getPaymentVerified() {
        return paymentVerified;
    }

    @JsonProperty("paymentVerified")
    public void setPaymentVerified(String paymentVerified) {
        this.paymentVerified = paymentVerified;
    }

    @JsonProperty("itemSoldFmt")
    public String getItemSoldFmt() {
        return itemSoldFmt;
    }

    @JsonProperty("itemSoldFmt")
    public void setItemSoldFmt(String itemSoldFmt) {
        this.itemSoldFmt = itemSoldFmt;
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
