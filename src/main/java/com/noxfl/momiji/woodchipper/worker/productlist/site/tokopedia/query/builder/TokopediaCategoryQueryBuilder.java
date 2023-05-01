package com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.query.builder;

import com.github.slugify.Slugify;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.noxfl.momiji.woodchipper.connection.impl.ApiCallerBuilderImpl;
import com.noxfl.momiji.woodchipper.model.schema.message.Category;
import com.noxfl.momiji.woodchipper.model.schema.message.Job;
import com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.TokopediaSiteCrawler;
import com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.query.graphql.schema.CategoryDetailQuery;
import com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.query.graphql.schema.SearchProductQuery;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class TokopediaCategoryQueryBuilder extends TokopediaQueryBuilder {

    private final String categoryIdentifier;
    private final int page;

    public TokopediaCategoryQueryBuilder(String categoryIdentifier, int page) {
        this.categoryIdentifier = categoryIdentifier;
        this.page = page;
    }

    public String build() throws IOException {
        int categoryId = getCategoryId(this.categoryIdentifier);
        return buildPayload(this.categoryIdentifier, categoryId, page).toString();
    }

    private int getCategoryId(String categoryIdentifier) throws IOException {

        JSONObject variables = new JSONObject();
        variables.put("identifier", categoryIdentifier);
        variables.put("intermediary", true);
        variables.put("safeSearch", true);

        JSONObject payload = new JSONObject();
        payload.put("operationName", CategoryDetailQuery.OPERATION_NAME);
        payload.put("variables", variables);
        payload.put("query", CategoryDetailQuery.QUERY);

        String response = new ApiCallerBuilderImpl(TokopediaSiteCrawler.TOKOPEDIA_API_ENDPOINT)
                .setHeaders(headers)
                .byPost(payload.toString())
                .build()
                .send();

        return JsonPath.using(Configuration.defaultConfiguration()).parse(response).read("$.data.CategoryDetailQuery.data.id", Integer.class);
    }

    private int calculateStart(int pageSize, int page) {
        return (pageSize * page) + 1;
    }

    private JSONObject buildPayload(String categoryIdentifier, int categoryId, int page) throws IOException {

        int start = calculateStart(60, page);

        String params = String.format(
                "page=%s&ob=&identifier=%s&sc=%s&user_id=0&rows=60&start=%s&source=directory&device=desktop" +
                                "&page=%s&related=true&st=product&safe_search=false", page, categoryIdentifier,
                categoryId, start, page);

        JSONObject gqlQueryParams = new JSONObject();
        gqlQueryParams.put("params", params);

        JSONObject payload = new JSONObject();
        payload.put("operationName", SearchProductQuery.OPERATION_NAME);
        payload.put("query", SearchProductQuery.QUERY);
        payload.put("variables", gqlQueryParams);

        return payload;
    }

}
