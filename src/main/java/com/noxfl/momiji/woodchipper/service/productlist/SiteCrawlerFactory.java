/**
 * 
 */
package com.noxfl.momiji.woodchipper.service.productlist;

import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;

/**
 * @author Fernando Nathanael
 *
 */
public interface SiteCrawlerFactory {

	public SiteCrawler getSiteCrawler(SiteContentType siteContentType);

}