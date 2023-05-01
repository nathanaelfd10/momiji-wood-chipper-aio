package com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.query.builder;

import com.github.slugify.Slugify;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TokopediaQueryBuilder {

    private TokopediaPageType tokopediaPageType;
    private int page = 1;
    protected HashMap<String, String> headers = new HashMap<>();

    public TokopediaQueryBuilder() {
        headers.put("User-Agent", "python-requests/2.28.1");
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "en-US,en;q=0.9,id-ID;q=0.8,id;q=0.7");
        headers.put("Connection", "keep-alive");
        headers.put("Origin", "https://www.tokopedia.com");
    }

    public TokopediaCategoryQueryBuilder asCategoryPage(String tokopediaCategoryUrl, int page) throws URISyntaxException {
        List<String> paths = new URIBuilder(tokopediaCategoryUrl).clearParameters().getPathSegments();
        if(paths.get(0).equalsIgnoreCase("p")) { paths.remove(0); }
        String categoryIdentifier = String.join("_", paths);

        return new TokopediaCategoryQueryBuilder(categoryIdentifier, page);
    }

    public TokopediaCategoryQueryBuilder asCategoryPage(List<String> categories, int page) {
        this.tokopediaPageType = TokopediaPageType.CATEGORY;
        Slugify slug = Slugify.builder().lowerCase(true).build();

        List<String> categoriesAsParams = categories.stream()
                .map(slug::slugify)
                .collect(Collectors.toList());

        String categoryIdentifier = String.join("_", categoriesAsParams);
        return new TokopediaCategoryQueryBuilder(categoryIdentifier, page);
    }


}
