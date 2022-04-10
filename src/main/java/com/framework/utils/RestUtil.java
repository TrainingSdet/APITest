package com.framework.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import com.framework.common.Configuration;
import com.framework.constants.Constants;
import com.framework.constants.HttpMethod;
import com.framework.pojo.HttpMethodParameters;
import com.framework.pojo.Session;

public class RestUtil {

	private static Logger logger = LoggerFactory.getLogger(RestUtil.class);
	CryptoCommonUtils cryptoCommonUtils = new CryptoCommonUtils();
	Configuration configuration = Configuration.getInstance();

	public Response getApiResponse(HttpMethodParameters httpParams, String url, String contentType, Session session,
			String httpMethod) {

		System.out.println("Entered getApiResponse method of RestUtil class");
		Response response = null;
		int APITimeOut = httpMethod.equals(HttpMethod.GET) ? Configuration.getInstance().getGetAPITimeout()
				: Configuration.getInstance().getUpdateAPITimeout();

		RequestSpecification requestSpecification = RestAssured.given()
				.config(RestAssuredConfig.config()
						.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))
						.httpClient(HttpClientConfig.httpClientConfig()
								.setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, APITimeOut)
								.setParam(CoreConnectionPNames.SO_TIMEOUT, APITimeOut)));

		// For path params starts
		if (httpParams != null) {
			if (httpParams.getPathParams() != null) {
				String pathParamStr = "";
				for (Map.Entry<String, ?> entry : httpParams.getPathParams().entrySet()) {
					String keyInPathParam = Constants.OPEN_CURLY_BRACKET_SYMBOL + entry.getKey()
							+ Constants.CLOSED_CURLY_BRACKET_SYMBOL;
					if (url.contains(keyInPathParam)) {
						url = url.replace(keyInPathParam, entry.getValue().toString());
					} else {
						pathParamStr = Constants.PATH_SEPARATOR + entry.getValue();
					}
				}
				url = url + pathParamStr;

			}
			if (null != contentType && !contentType.isEmpty()) {

				requestSpecification = requestSpecification.contentType(contentType);
			}

			if (httpParams != null) {
				if (httpParams.getFormParams() != null) {
					requestSpecification = requestSpecification.formParams(httpParams.getFormParams());
				}

				if (httpParams.getQueryParams() != null) {
					requestSpecification = requestSpecification.queryParams(httpParams.getQueryParams());
				}

				if (httpParams.getBodyParams() != null) {
					requestSpecification = requestSpecification.body(httpParams.getBodyParams());
				}
				if (httpParams.getAddHeaders()!= null) {
					requestSpecification = requestSpecification.headers(httpParams.getAddHeaders());
				}

				if (session == null) {
					System.out.println("Making REST API Call - Inside RestUtil" + url);
					response = callRestAPI(requestSpecification, configuration.getApiUrlBasePath(), url, httpMethod);
					return response;
				}
			}			
		}
		return response;
	}

	private Response callRestAPI(RequestSpecification requestSpecification, String apiPath, String url, String method) {	

		Response response = null;
		if (url != null) {
			apiPath = apiPath + url;
		}
		requestSpecification.relaxedHTTPSValidation();
		requestSpecification.log().all();
		response = requestSpecification.request(Method.valueOf(method), apiPath);
		response.then().log().all();
		return response;
	}
	
}
