/**
 * 
 */
package com.noxfl.momiji.woodchipper.worker.productlist;

import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;

/**
 * @author Fernando Nathanael
 *
 */
public interface SiteCrawlerFactory {

	public SiteCrawler getSiteCrawler(SiteContentType siteContentType);

}