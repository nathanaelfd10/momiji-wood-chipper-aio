package com.noxfl.momiji.woodchipper.connection.impl;

import com.noxfl.momiji.woodchipper.connection.ApiCaller;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApiCallerImpl implements ApiCaller {

    private final HttpUriRequest request;

    public ApiCallerImpl(HttpUriRequest request) {
        this.request = request;
    }


    @Override
    public String send() {
        String responseString = null;

        try {
            CloseableHttpClient httpClient = HttpClients.custom()
                    .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
                    .build();
            CloseableHttpResponse response = httpClient.execute(request);

            responseString = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseString;
    }

}
