/**
 * 
 */
package com.noxfl.momiji.woodchipper.service.productlist.impl;

import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;
import com.noxfl.momiji.woodchipper.service.productlist.SiteCrawler;
import com.noxfl.momiji.woodchipper.service.productlist.SiteCrawlerFactory;
import com.noxfl.momiji.woodchipper.service.productlist.site.bukalapak.category.BukalapakCategorySiteCrawler;
import com.noxfl.momiji.woodchipper.service.productlist.site.tokopedia.category.TokopediaCategorySiteCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Fernando Nathanael
 *
 */
@Component
public class SiteCrawlerFactoryImpl implements SiteCrawlerFactory {

	private TokopediaCategorySiteCrawler tokopediaCategorySiteCrawler;

	@Autowired
	public void setTokopediaSiteCrawler(TokopediaCategorySiteCrawler tokopediaCategorySiteCrawler) {
		this.tokopediaCategorySiteCrawler = tokopediaCategorySiteCrawler;
	}

	private BukalapakCategorySiteCrawler bukalapakCategorySiteCrawler;

	@Autowired
	public void setBukalapakCategorySiteCrawler(BukalapakCategorySiteCrawler bukalapakCategorySiteCrawler) {
		this.bukalapakCategorySiteCrawler = bukalapakCategorySiteCrawler;
	}

	@Override
	public SiteCrawler getSiteCrawler(SiteContentType siteContentType) {

		switch (siteContentType) {
			case TOKOPEDIA_CATEGORY_JSON -> { return tokopediaCategorySiteCrawler; }
			case BUKALAPAK_CATEGORY_HTML -> { return bukalapakCategorySiteCrawler; }
			default -> throw new IllegalArgumentException("No site crawler for PageType: " + siteContentType);
		}

	}

}
