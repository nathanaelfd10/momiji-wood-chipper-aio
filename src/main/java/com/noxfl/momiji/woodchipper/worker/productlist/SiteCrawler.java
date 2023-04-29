/**
 * 
 */
package com.noxfl.momiji.woodchipper.worker.productlist;

import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.Output;

import java.io.IOException;
import java.net.URISyntaxException;
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
	public List<Output> fetchProducts(MomijiMessage momijiMessage) throws IOException, URISyntaxException;

}
