/**
 * 
 */
package com.noxfl.momiji.woodchipper.worker.productlist.impl;

import com.noxfl.momiji.woodchipper.model.schema.message.SiteContentType;
import com.noxfl.momiji.woodchipper.worker.TargetUrlBuilder;
import com.noxfl.momiji.woodchipper.worker.productlist.SiteCrawler;
import com.noxfl.momiji.woodchipper.worker.productlist.SiteCrawlerFactory;
import com.noxfl.momiji.woodchipper.worker.productlist.site.JsoupSiteCrawler;
import com.noxfl.momiji.woodchipper.worker.productlist.site.bukalapak.category.BukalapakCategorySiteCrawler;
import com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.category.TokopediaCategorySiteCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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

	@Override
	public SiteCrawler getSiteCrawler(SiteContentType siteContentType) {

		switch (siteContentType) {
			case TOKOPEDIA_CATEGORY_JSON -> { return tokopediaCategorySiteCrawler; }
			case BUKALAPAK_CATEGORY_HTML -> {
				String productsSelector = ".te-product-card";
				String productUrlSelector = "div.bl-thumbnail--slider a";
				String productUrlSelectorAttribute = "href";

				TargetUrlBuilder targetUrlBuilder = new TargetUrlBuilder("search[rating_gte]", "");

				return new JsoupSiteCrawler(targetUrlBuilder, productsSelector, productUrlSelector, productUrlSelectorAttribute);
			}
			default -> throw new IllegalArgumentException("No site crawler for PageType: " + siteContentType);
		}

	}

}
