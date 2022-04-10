package com.framework.pojo;

import java.util.HashMap;
import java.util.Map;

public class HttpMethodParameters {

	private Map<String, ?> formParams;
	private Map<String, Object> pathParams;
	private Map<String, ?> restformParams;
	private String bodyParams;
	private Map<String, ?> addHeaders;
	private HashMap<String , Object> headers;
	private Map<String, ?> queryParams;
	private String httpMethod;
	
	
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public Map<String, ?> getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(Map<String, ?> queryParams) {
		this.queryParams = queryParams;
	}
	public Map<String, ?> getFormParams() {
		return formParams;
	}
	public void setFormParams(Map<String, ?> formParams) {
		this.formParams = formParams;
	}
	public Map<String, Object> getPathParams() {
		return pathParams;
	}
	public void setPathParams(Map<String, Object> pathParams) {
		this.pathParams = pathParams;
	}
	public Map<String, ?> getRestformParams() {
		return restformParams;
	}
	public void setRestformParams(Map<String, ?> restformParams) {
		this.restformParams = restformParams;
	}
	public String getBodyParams() {
		return bodyParams;
	}
	public void setBodyParams(String bodyParams) {
		this.bodyParams = bodyParams;
	}
	public Map<String, ?> getAddHeaders() {
		return addHeaders;
	}
	public void setAddHeaders(Map<String, ?> addHeaders) {
		this.addHeaders = addHeaders;
	}
	public HashMap<String, Object> getHeaders() {
		return headers;
	}
	public void setHeaders(HashMap<String, Object> headers) {
		this.headers = headers;
	}
	
}
