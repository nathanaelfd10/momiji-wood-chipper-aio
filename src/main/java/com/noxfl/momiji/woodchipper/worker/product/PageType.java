/**
 * 
 */
package com.noxfl.momiji.woodchipper.worker.product;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Fernando Nathanael
 *
 */
public enum PageType {
	@JsonProperty("TOKOPEDIA_CATEGORY")
	TOKOPEDIA_CATEGORY,
	@JsonProperty("TOKOPEDIA_PRODUCT_DETAIL")
	TOKOPEDIA_PRODUCT_DETAIL
}
