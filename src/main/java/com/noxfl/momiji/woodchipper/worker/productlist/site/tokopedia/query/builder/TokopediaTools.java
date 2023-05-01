package com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia.query.builder;

import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;
import java.util.List;

public class TokopediaTools {

    private String getCategoryIdentifier(String url) throws URISyntaxException {
        List<String> paths = new URIBuilder(url).clearParameters().getPathSegments();
        if(paths.get(0).equalsIgnoreCase("p")) {
            paths.remove(0);
        }

        return String.join("_", paths);
    }

}
