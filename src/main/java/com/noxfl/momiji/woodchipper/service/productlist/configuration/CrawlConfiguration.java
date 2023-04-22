/**
 * 
 */
package com.noxfl.momiji.woodchipper.service.productlist.configuration;

import com.noxfl.momijitreehouse.crawler.MethodType;
import com.noxfl.momijitreehouse.crawler.connection.Proxy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Fernando Nathanael
 *
 */
@AllArgsConstructor
@Getter
@Setter
public class CrawlConfiguration {

	private String name;
	private String baseUrl;
	private MethodType methodType;
	private BrowserConfiguration browserConfiguration;
	private String productSplitPath;
	private int minimumPage;
	private int maximumPage;
	private Proxy proxy;

}