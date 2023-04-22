/**
 * 
 */
package com.noxfl.momiji.woodchipper.service.productlist;

import com.noxfl.momiji.woodchipper.model.schema.message.Content;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fernando Nathanael
 *
 */
public interface SiteCrawler {

	/**
	 * Crawls products by category.
	 *
	 * @param momijiMessage
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public List<Content> fetchProducts(MomijiMessage momijiMessage) throws IOException, URISyntaxException;

}
