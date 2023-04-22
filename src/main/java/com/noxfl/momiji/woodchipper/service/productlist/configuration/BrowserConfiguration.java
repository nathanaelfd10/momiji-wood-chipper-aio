/**
 * 
 */
package com.noxfl.momiji.woodchipper.service.productlist.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Fernando Nathanael
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrowserConfiguration {

	private int paginationStart;
	private String nextButtonSelector;
	private ScrollOption scrollOption;

}