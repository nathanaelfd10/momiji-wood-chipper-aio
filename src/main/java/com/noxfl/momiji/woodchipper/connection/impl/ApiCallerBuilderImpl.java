/**
 * 
 */
package com.noxfl.momiji.woodchipper.connection.impl;

import com.google.protobuf.Api;
import com.noxfl.momiji.woodchipper.connection.ApiCallType;
import com.noxfl.momiji.woodchipper.connection.ApiCallerBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Fernando Nathanael
 *
 */

public class ApiCallerBuilderImpl implements ApiCallerBuilder {

	private String url;
	private ApiCallType apiCallType;
	private String body;
	private HashMap<String, String> headers;
	private HttpUriRequest request;

	public ApiCallerBuilderImpl(String url) {
		this.url = url;
	}

	public ApiCallerBuilder byPost(String body) {
		this.apiCallType = ApiCallType.POST;
		this.body = body;
		return this;
	}

	public ApiCallerBuilder byGet() {
		this.apiCallType = ApiCallType.GET;
		return this;
	}

	public ApiCallerBuilder setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
		return this;
	}

	public ApiCallerImpl build() {
		ApiCallType apiCallType = this.apiCallType;

		switch (apiCallType) {
			case POST -> {
				HttpPost post = new HttpPost(this.url);
				post.setEntity(new StringEntity(this.body, ContentType.APPLICATION_JSON);
				this.request = post;
			}
			case GET -> { this.request = new HttpGet(this.url); }
			default -> { throw new IllegalArgumentException("No matching ApiCallType: " + apiCallType); }
		}

		for (Entry<String, String> header : headers.entrySet())
			this.request.setHeader(header.getKey(), header.getValue());

		return new ApiCallerImpl(this.request);
	}

//	public String send() {
//		return send(request).toString();
//	}



	//	public JSONObject fetchPost(String body, HashMap<String, String> headers, String targetUrl) throws IOException {
//
//		HttpPost post = new HttpPost(targetUrl);
//		StringEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
//		post.setEntity(entity);
//		for (Entry<String, String> header : headers.entrySet())
//			post.setHeader(header.getKey(), header.getValue());
//
//		JSONObject result = null;
//
//		try {
//			CloseableHttpClient httpClient = HttpClients.custom()
//					.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
//					.build();
//			CloseableHttpResponse response = httpClient.execute(post);
//
//			String responseString = EntityUtils.toString(response.getEntity());
//
//			result = new JSONObject(responseString);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//
//	}


}