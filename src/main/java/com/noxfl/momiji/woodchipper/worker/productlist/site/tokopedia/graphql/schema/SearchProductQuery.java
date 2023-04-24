package com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.graphql.schema;

/**
 * @author Fernando Nathanael
 *
 */
public class SearchProductQuery {

    public static final String OPERATION_NAME = "SearchProductQuery";

    public static final String QUERY = "query SearchProductQuery($params: String, $adParams: String) {\n" +
            " CategoryProducts: searchProduct(params: $params) {\n" +
            " count\n" +
            " data: products {\n" +
            " id\n" +
            " url\n" +
            " imageUrl: image_url\n" +
            " imageUrlLarge: image_url_700\n" +
            " catId: category_id\n" +
            " gaKey: ga_key\n" +
            " countReview: count_review\n" +
            " discountPercentage: discount_percentage\n" +
            " preorder: is_preorder\n" +
            " name\n" +
            " price\n" +
            " priceInt: price_int\n" +
            " original_price\n" +
            " rating\n" +
            " wishlist\n" +
            " labels {\n" +
            " title\n" +
            " color\n" +
            " __typename\n" +
            " }\n" +
            " badges {\n" +
            " imageUrl: image_url\n" +
            " show\n" +
            " __typename\n" +
            " }\n" +
            " shop {\n" +
            " id\n" +
            " url\n" +
            " name\n" +
            " goldmerchant: is_power_badge\n" +
            " official: is_official\n" +
            " reputation\n" +
            " clover\n" +
            " location\n" +
            " __typename\n" +
            " }\n" +
            " labelGroups: label_groups {\n" +
            " position\n" +
            " title\n" +
            " type\n" +
            " __typename\n" +
            " }\n" +
            " __typename\n" +
            " }\n" +
            " __typename\n" +
            " }\n" +
            " displayAdsV3(displayParams: $adParams) {\n" +
            " data {\n" +
            " id\n" +
            " ad_ref_key\n" +
            " redirect\n" +
            " sticker_id\n" +
            " sticker_image\n" +
            " productWishListUrl: product_wishlist_url\n" +
            " clickTrackUrl: product_click_url\n" +
            " shop_click_url\n" +
            " product {\n" +
            " id\n" +
            " name\n" +
            " wishlist\n" +
            " image {\n" +
            " imageUrl: s_ecs\n" +
            " trackerImageUrl: s_url\n" +
            " __typename\n" +
            " }\n" +
            " url: uri\n" +
            " relative_uri\n" +
            " price: price_format\n" +
            " campaign {\n" +
            " original_price\n" +
            " discountPercentage: discount_percentage\n" +
            " __typename\n" +
            " }\n" +
            " wholeSalePrice: wholesale_price {\n" +
            " quantityMin: quantity_min_format\n" +
            " quantityMax: quantity_max_format\n" +
            " price: price_format\n" +
            " __typename\n" +
            " }\n" +
            " count_talk_format\n" +
            " countReview: count_review_format\n" +
            " category {\n" +
            " id\n" +
            " __typename\n" +
            " }\n" +
            " preorder: product_preorder\n" +
            " product_wholesale\n" +
            " free_return\n" +
            " isNewProduct: product_new_label\n" +
            " cashback: product_cashback_rate\n" +
            " rating: product_rating\n" +
            " top_label\n" +
            " bottomLabel: bottom_label\n" +
            " __typename\n" +
            " }\n" +
            " shop {\n" +
            " image_product {\n" +
            " image_url\n" +
            " __typename\n" +
            " }\n" +
            " id\n" +
            " name\n" +
            " domain\n" +
            " location\n" +
            " city\n" +
            " tagline\n" +
            " goldmerchant: gold_shop\n" +
            " gold_shop_badge\n" +
            " official: shop_is_official\n" +
            " lucky_shop\n" +
            " uri\n" +
            " owner_id\n" +
            " is_owner\n" +
            " badges {\n" +
            " title\n" +
            " image_url\n" +
            " show\n" +
            " __typename\n" +
            " }\n" +
            " __typename\n" +
            " }\n" +
            " applinks\n" +
            " __typename\n" +
            " }\n" +
            " template {\n" +
            " isAd: is_ad\n" +
            " __typename\n" +
            " }\n" +
            " __typename\n" +
            " }\n" +
            "}";

}
