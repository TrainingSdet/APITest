package com.framework.utils;

import io.restassured.response.Response;

import com.framework.common.Configuration;
import com.framework.pojo.HttpMethodParameters;

import io.restassured.builder.ResponseBuilder;

public class CryptoCommonUtils {

	public Response getUpdatedResponse(Response originalResponse,String jsonStrDecryptedResponse) throws InstantiationException, IllegalAccessException {
		ResponseBuilder builder1 = ResponseBuilder.class.newInstance().clone(originalResponse);
		builder1.setBody(jsonStrDecryptedResponse);
		Response response1 = builder1.build();
		System.out.println("==============================DecryptedResponse==============================");
		response1.then().log().all();
		return response1;

	}
}
