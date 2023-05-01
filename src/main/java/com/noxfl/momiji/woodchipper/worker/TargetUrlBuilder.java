package com.noxfl.momiji.woodchipper.worker;

import com.noxfl.momiji.woodchipper.model.schema.message.CustomParam;
import com.noxfl.momiji.woodchipper.model.schema.message.Filter;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;
import java.util.List;

public class TargetUrlBuilder {

//    private final Filter filter;
//
//    public TargetUrlBuilder(Filter filter) {
//        this.filter = filter;
//    }

    private String targetUrl;
    private URIBuilder uriBuilder;

    public TargetUrlBuilder(String targetUrl) {
        this.targetUrl = targetUrl;
        this.uriBuilder = new URIBuilder();
    }

    public TargetUrlBuilder setPage(String paginationParameterKey, int page) {
        this.uriBuilder.addParameter(paginationParameterKey, String.valueOf(page));
        return this;
    }

    public TargetUrlBuilder withFilter(Filter filter) {

        if(filter.getMinRating() != -1)
            this.uriBuilder.addParameter(filter.getMinRatingParameterKey(), String.valueOf(filter.getMinRating()));

        if(filter.getMaxRating() != -1)
            this.uriBuilder.addParameter(filter.getMaxRatingParameterKey(), String.valueOf(filter.getMaxRating()));

        if(filter.getCustomFilters() != null && filter.getCustomFilters().size() > 0) {
            for (CustomParam customFilter : filter.getCustomFilters()) {
                this.uriBuilder.addParameter(customFilter.getKey(), customFilter.getValue());
            }
        }

        for(CustomParam customFilter : filter.getCustomFilters())
            this.uriBuilder.addParameter(customFilter.getKey(), customFilter.getValue());

        return this;
    }

    public String build() throws URISyntaxException {
        return this.uriBuilder.build().toString();
    }
//
//    public String build(String targetUrl, Filter filter, List<CustomParam> customFilters) throws URISyntaxException {
//
//        URIBuilder uriBuilder = new URIBuilder(targetUrl);
//
//        for(CustomParam customFilter : customFilters)
//            uriBuilder.addParameter(customFilter.getKey(), customFilter.getValue());
//
//        targetUrl = uriBuilder.build().toString();
//
//        return build(targetUrl, filter);
//    }
//
//
//    public String build(String targetUrl, Filter filter) throws URISyntaxException {
//
//        URIBuilder uriBuilder = new URIBuilder(targetUrl);
//
//        if(filter.getMinRating() != -1)
//            uriBuilder.addParameter(filter.getMinRatingParameterKey(), String.valueOf(filter.getMinRating()));
//
//        if(filter.getMaxRating() != -1)
//            uriBuilder.addParameter(filter.getMaxRatingParameterKey(), String.valueOf(filter.getMaxRating()));
//
//        if(filter.getCustomFilters() != null && filter.getCustomFilters().size() > 0) {
//            for (CustomParam customFilter : filter.getCustomFilters()) {
//                uriBuilder.addParameter(customFilter.getKey(), customFilter.getValue());
//            }
//        }
//
//        return uriBuilder.build().toString();
//    }

}
