package com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.category;

import com.github.slugify.Slugify;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.noxfl.momiji.woodchipper.connection.ApiFetcher;
import com.noxfl.momiji.woodchipper.model.schema.message.*;
import com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.TokopediaSiteCrawler;
import com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.graphql.schema.CategoryDetailQuery;
import com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.graphql.schema.SearchProductQuery;
import com.noxfl.momiji.woodchipper.util.UriUtils;
import net.minidev.json.JSONStyle;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fernando Nathanael
 *
 */
@Component
public class TokopediaCategorySiteCrawler extends TokopediaSiteCrawler {



    public TokopediaCategorySiteCrawler(ApiFetcher apiFetcher) {
        super(apiFetcher);

    }

    //TODO: Reusable function, move somewhere else
    private List<String> splitProductCards(String jsonString, String splitPath) {
        final ContentType contentType = ContentType.JSON;

        net.minidev.json.JSONObject[] contents =
                JsonPath.using(Configuration.defaultConfiguration())
                        .parse(jsonString)
                        .read(splitPath, net.minidev.json.JSONObject[].class);

        return Arrays.stream(contents)
                .map(json -> json.toJSONString(JSONStyle.MAX_COMPRESS))
                .toList();
    }

    /**
     * Builds GraphQL query payload
     *
     * @param category
     * @param page
     * @return GraphQL Query
     */
    private String buildVariablesParam(String url, int page) throws IOException, URISyntaxException {
        int rows = 60;
        int start = 61;

        String categoryIdentifier = buildCategoryIdentifier(url);
        int categoryId = getCategoryId(categoryIdentifier);

        HashMap<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("rows", String.valueOf(rows));
        params.put("source", "directory");
        params.put("sc", String.valueOf(categoryId));
        params.put("identifier", categoryIdentifier);
        params.put("start", String.valueOf(start));
        params.put("st", "product");
        params.put("device", "desktop");
        params.put("safe_search", "false");
        params.put("related", "true");
        params.put("ob", "");

        String output = buildParams(params);

        return output.startsWith("?") ? output.substring(1, output.length()) : output;
    }

    private JSONObject buildPayload(Job job, int page) throws IOException, URISyntaxException {
        JSONObject gqlQueryParams = new JSONObject();
        gqlQueryParams.put("params", buildVariablesParam(job.getCategory().getUrl(), page));
//            gqlQueryParams.put("adParams", buildVariablesAdParam(i));

        JSONObject payload = new JSONObject();
        payload.put("operationName", SearchProductQuery.OPERATION_NAME);
        payload.put("query", SearchProductQuery.QUERY);
        payload.put("variables", gqlQueryParams);

        return payload;
    }

    @Override
    protected List<Content> fetch(MomijiMessage momijiMessage) throws IOException, URISyntaxException {

        Job job = momijiMessage.getJob();

        JSONObject payload = buildPayload(job, this.getCurrentPage());

        // Crawl delay
        try {
            Thread.sleep(GLOBAL_POLITENESS_TIMEOUT_TOKOPEDIA);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String response = apiFetcher.fetchPost(payload.toString(), headers, TOKOPEDIA_API_ENDPOINT).toString();

        List<String> productCards = splitProductCards(response, "$.data.CategoryProducts.data[*]");

        List<Content> output = new ArrayList<>();

        for(String card : productCards) {

            List<Content> contents = new ArrayList<>();

            String url = JsonPath.using(Configuration.defaultConfiguration())
                    .parse(card)
                    .read("$.url");

            url = UriUtils.clearParameter(url).toString();

            Content content = momijiMessage.getJob().getContent();

            content.setUrl(url);
            content.setProduct(card);

            output.add(content);

        }

        return output;
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
        String response = apiFetcher.fetchPost(payload.toString(), headers, TOKOPEDIA_API_ENDPOINT).toString();

        return JsonPath.using(Configuration.defaultConfiguration()).parse(response).read("$.data.CategoryDetailQuery.data.id", Integer.class);
    }

    private String buildCategoryIdentifier(String url) throws URISyntaxException {
        List<String> paths = new URIBuilder(url).clearParameters().getPathSegments();
        if(paths.get(0).equalsIgnoreCase("p")) {
            paths.remove(0);
        }

        return String.join("_", paths);
    }

    private String buildCategoryIdentifier(Category category) {

        Slugify slug = Slugify.builder().lowerCase(true).build();

        List<String> categoriesAsParams = category.getCategoryBreadcrumb().stream()
                .map(slug::slugify)
                .collect(Collectors.toList());

        return String.join("_", categoriesAsParams);
    }

}