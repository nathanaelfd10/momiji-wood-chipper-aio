/**
 * 
 */
package com.noxfl.momiji.woodchipper.model.schema.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Fernando Nathanael
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Site {

	private String id;
	private String name;
	private String baseUrl;

}
