package com.noxfl.momiji.woodchipper.worker;

import com.noxfl.momiji.woodchipper.model.schema.message.CustomParam;
import com.noxfl.momiji.woodchipper.model.schema.message.Filter;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;
import java.util.List;

public class TargetUrlBuilder {

    private final String minRatingParameterKey;

    private final String maxRatingParameterKey;

    public TargetUrlBuilder(String minRatingParameterKey, String maxRatingParameterKey) {
        this.minRatingParameterKey = minRatingParameterKey;
        this.maxRatingParameterKey = maxRatingParameterKey;

        Filter filter = new Filter();

        filter.getClass().getFields();

    }

    public String build(String targetUrl, Filter filter, List<CustomParam> customFilters) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(targetUrl);

        for(CustomParam customFilter : customFilters)
            uriBuilder.addParameter(customFilter.getKey(), customFilter.getValue());

        targetUrl = uriBuilder.build().toString();

        return build(targetUrl, filter);
    }


    public String build(String targetUrl, Filter filter) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(targetUrl);

        if(filter.getMinRating() != -1)
            uriBuilder.addParameter(minRatingParameterKey, String.valueOf(filter.getMinRating()));

        if(filter.getMaxRating() != -1)
            uriBuilder.addParameter(maxRatingParameterKey, String.valueOf(filter.getMaxRating()));

        if(filter.getCustomFilters() != null && filter.getCustomFilters().size() > 0) {
            for (CustomParam customFilter : filter.getCustomFilters()) {
                uriBuilder.addParameter(customFilter.getKey(), customFilter.getValue());
            }
        }

        return uriBuilder.build().toString();
    }

}
