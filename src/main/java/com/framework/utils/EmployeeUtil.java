package com.framework.utils;

import java.util.HashMap;

import com.framework.common.Configuration;
import com.framework.constants.Constants;
import com.framework.constants.HttpMethod;
import com.framework.constants.URLConstants;
import com.framework.pojo.HttpMethodParameters;
import com.framework.pojo.Session;

import io.restassured.response.Response;

public class EmployeeUtil {
	
	private RestUtil restUtilObj = new RestUtil(); 
	private Configuration config = Configuration.getInstance();
	
	 public Response onBoardEmployee(HttpMethodParameters httpParams, Session session) {
		    getAPIHeaders(httpParams, session);
		    return this.restUtilObj.getApiResponse(httpParams, URLConstants.ADD_EMPLOYEE, null, session, HttpMethod.POST);
	}
	 
	 public Response updateEmployee(HttpMethodParameters httpParams, Session session) {
		    getAPIHeaders(httpParams, session);
		    return this.restUtilObj.getApiResponse(httpParams, URLConstants.UPDATE_EMPLOYEE, null, session, HttpMethod.PATCH);
	}
	 
	 public Response getEmployees(HttpMethodParameters httpParams, Session session) {
		    getAPIHeaders(httpParams, session);
		    return this.restUtilObj.getApiResponse(httpParams, URLConstants.FETCH_EMPLOYEE, null, session, HttpMethod.GET);
	} 
	 
	public HashMap<String, Object> getAPIHeaders(HttpMethodParameters httpParams, Session session) {
		HashMap<String, Object> headers = (httpParams.getHeaders() != null) ? httpParams.getHeaders() : new HashMap<>();
		if (!headers.containsKey(Constants.API_VERSION_HEADER))
			headers.put(Constants.API_VERSION_HEADER, this.config.getApiVersion());
		if (!headers.containsKey(Constants.CONTENT_TYPE_HEADER))
			headers.put(Constants.CONTENT_TYPE_HEADER, Constants.APPLICATION_JSON_CONTENT_TYPE);
		httpParams.setHeaders(headers);
		return headers;
	}
	 
	 
	 
}
