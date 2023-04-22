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
public class ScrollOption {

	private int minimumRange;
	private int maximumRange;
	private int delay;
	private int count;

}
