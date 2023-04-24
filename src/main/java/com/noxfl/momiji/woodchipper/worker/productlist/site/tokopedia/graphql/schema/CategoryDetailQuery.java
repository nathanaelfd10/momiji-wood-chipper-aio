package com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.graphql.schema;

public class CategoryDetailQuery {

    public static final String OPERATION_NAME = "CategoryDetailQuery";

    public static final String QUERY = """
                query CategoryDetailQuery($identifier: String!, $intermediary: Boolean!, $safeSearch: Boolean!) {
                 CategoryDetailQuery: CategoryDetailQueryV3(identifier: $identifier, intermediary: $intermediary, safeSearch: $safeSearch) {
                 header {
                 code
                 serverProcessTime
                 message
                 __typename
                 }
                 data {
                 id
                 name
                 useDiscoPage
                 discoIdentifier
                 url
                 redirectionURL
                 child {
                 id
                 name
                 url
                 thumbnailImage
                 isAdult
                 applinks
                 __typename
                 }
                 __typename
                 }
                 __typename
                 }
                }
                """;


}
