package com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.query.graphql.schema;

/**
 * @author Fernando Nathanael
 *
 */
public class SearchProductQuery {

    public static final String OPERATION_NAME = "SearchProductQuery";

    public static final String QUERY = """
            query SearchProductQuery($params: String) {
              CategoryProducts: searchProduct(params: $params) {
                count
                data: products {
                  id
                  url
                  imageUrl: image_url
                  imageUrlLarge: image_url_700
                  catId: category_id
                  gaKey: ga_key
                  countReview: count_review
                  discountPercentage: discount_percentage
                  preorder: is_preorder
                  name
                  price
                  priceInt: price_int
                  original_price
                  rating
                  wishlist
                  labels {
                    title
                    color
                    __typename
                  }
                  badges {
                    imageUrl: image_url
                    show
                    __typename
                  }
                  shop {
                    id
                    url
                    name
                    goldmerchant: is_power_badge
                    official: is_official
                    reputation
                    clover
                    location
                    __typename
                  }
                  labelGroups: label_groups {
                    position
                    title
                    type
                    __typename
                  }
                  __typename
                }
                __typename
              }
            }
            """;


}
