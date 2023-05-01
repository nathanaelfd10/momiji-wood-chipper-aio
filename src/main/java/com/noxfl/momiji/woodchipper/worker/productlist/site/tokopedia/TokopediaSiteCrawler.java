/**
 * 
 */
package com.noxfl.momiji.woodchipper.worker.productlist.site.tokopedia;

import com.noxfl.momiji.woodchipper.connection.ApiCaller;
import com.noxfl.momiji.woodchipper.worker.productlist.site.GenericSiteCrawler;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Fernando Nathanael
 *
 */
public abstract class TokopediaSiteCrawler extends GenericSiteCrawler {

	public static final String TOKOPEDIA_API_ENDPOINT = "https://gql.tokopedia.com";

	public static final int GLOBAL_POLITENESS_TIMEOUT_TOKOPEDIA = 2000;

	protected final ApiCaller apiFetcher;

	protected HashMap<String, String> headers = new HashMap<>();

	@Autowired
	public TokopediaSiteCrawler(ApiCaller apiFetcher) {
		this.apiFetcher = apiFetcher;
		this.setPaginationStart(1);

		headers.put("User-Agent", "python-requests/2.28.1");
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "*/*");
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "en-US,en;q=0.9,id-ID;q=0.8,id;q=0.7");
		headers.put("Connection", "keep-alive");
		headers.put("Origin", "https://www.tokopedia.com");
	}

	/**
	 * Build GraphQL query parameters
	 * 
	 * @param params
	 * @return
	 */
	public String buildParams(HashMap<String, String> params) {
		URIBuilder uri = new URIBuilder();

		for (Entry<String, String> param : params.entrySet()) {
			uri.addParameter(param.getKey(), param.getValue());
		}

		return uri.toString();
	}

}
