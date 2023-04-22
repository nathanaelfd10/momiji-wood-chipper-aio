/**
 * 
 */
package com.noxfl.momiji.woodchipper.model.schema.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Fernando Nathanael
 *
 */
public enum PageType {
	@JsonProperty("CATEGORY")
	CATEGORY,
	@JsonProperty("DETAIL")
	DETAIL
}

