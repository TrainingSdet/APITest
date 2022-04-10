package com.framework.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.eclipse.jetty.http.HttpStatus;
import org.testng.Assert;

import com.framework.constants.HttpMethod;
import com.framework.employeevalidators.DBValidator;
import com.framework.employeevalidators.JsonSchemaValidator;

import io.restassured.response.Response;

public class EmployeeGenerics {

	String[] negativeTestScenarios = {};
	List<String> negativeScenarioList = Arrays.asList(negativeTestScenarios);
	JsonParser jsonParser = new JsonParser();

	public void verifyEmployeeApiResponse(String testCaseId, String restAPIMethod, Response employeeResponse,
			String negativeTestScenario, HashMap<String, ArrayList<String>> negativeExpectedKeyValuesMap,
			int expectedStatusCode, String schemaFile, String responseValidationProcedure) throws SQLException {

		if (expectedStatusCode != employeeResponse.getStatusCode()) {
			Assert.fail("Expected and Actual ErrorCode doesn't match");
		}
		DBValidator dbValidator = new DBValidator();
		JsonSchemaValidator jsonSchemaValidator = new JsonSchemaValidator();
		if (restAPIMethod.equals(HttpMethod.POST)) {
			JsonObject employeeResObj = ((JsonObject) jsonParser.parse(employeeResponse.asString()).getAsJsonObject());
			if (expectedStatusCode == HttpStatus.CREATED_201) {
				if ("ALL".equals(responseValidationProcedure.toUpperCase())) {
					dbValidator.validateDB(((JsonObject) employeeResObj.get("employee")).get("id").getAsInt());
					jsonSchemaValidator.validateResponseAgainstSchema(employeeResObj.toString(), schemaFile);
				}
				if ("DB".equals(responseValidationProcedure.toUpperCase())) {
					dbValidator.validateDB(((JsonObject) employeeResObj.get("employee")).get("id").getAsInt());
				}
				if ("SCHEMA".equals(responseValidationProcedure.toUpperCase())) {
					jsonSchemaValidator.validateResponseAgainstSchema(employeeResObj.toString(), schemaFile);
				}
			}
			if (expectedStatusCode == HttpStatus.BAD_REQUEST_400 || expectedStatusCode == HttpStatus.NOT_FOUND_404) {
				if (employeeResponse.getStatusCode() != expectedStatusCode
						|| employeeResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR_500) {
					String errMsg = employeeResObj.get("errorMessage").getAsString();
					Assert.fail(errMsg);
				}

				if (employeeResponse.getStatusCode() == HttpStatus.BAD_REQUEST_400
						|| employeeResponse.getStatusCode() == HttpStatus.NOT_FOUND_404) {

					String expectedErrorMessage = negativeExpectedKeyValuesMap.get(negativeTestScenario).get(2);
					String expectedErrorCode = negativeExpectedKeyValuesMap.get(negativeTestScenario).get(1);
					if (!employeeResObj.get("httpStatusCode").getAsString()
							.equals(negativeExpectedKeyValuesMap.get(negativeTestScenario).get(1))) {
						Assert.fail("Expected Error Code = " + expectedErrorCode + "Actual Error Code ="
								+ employeeResObj.get("httpStatusCode").getAsString());
					}

					if (!employeeResObj.get("errorMessage").getAsString().equals(expectedErrorMessage)) {
						Assert.fail("Expected Error Message = " + expectedErrorMessage + "Actual Error Message ="
								+ employeeResObj.get("errorMessage").getAsString());

					}

				}
			}

		}
		if (restAPIMethod.equals(HttpMethod.PATCH)) {

			JsonObject employeeResObj = ((JsonObject) jsonParser.parse(employeeResponse.asString()).getAsJsonObject());
			if (employeeResponse.getStatusCode() != expectedStatusCode
					|| employeeResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR_500) {
				String errMsg = employeeResObj.get("errorMessage").getAsString();
				Assert.fail(errMsg);
			}
			if (employeeResponse.getStatusCode() == HttpStatus.OK_200) {
				dbValidator.validateDB(((JsonObject) employeeResObj.get("employee")).get("id").getAsInt());
			}
			if (employeeResponse.getStatusCode() == HttpStatus.BAD_REQUEST_400
					|| employeeResponse.getStatusCode() == HttpStatus.NOT_FOUND_404) {

				String expectedErrorMessage = negativeExpectedKeyValuesMap.get(negativeTestScenario).get(2);
				String expectedErrorCode = negativeExpectedKeyValuesMap.get(negativeTestScenario).get(1);
				if (!employeeResObj.get("httpStatusCode").getAsString()
						.equals(negativeExpectedKeyValuesMap.get(negativeTestScenario).get(1))) {
					Assert.fail("Expected Error Code = " + expectedErrorCode + "Actual Error Code ="
							+ employeeResObj.get("httpStatusCode").getAsString());
				}
				if (!employeeResObj.get("errorMessage").getAsString().equals(expectedErrorMessage)) {
					Assert.fail("Expected Error Message = " + expectedErrorMessage + "Actual Error Message ="
							+ employeeResObj.get("errorMessage").getAsString());

				}

			}

		}
		if (restAPIMethod.equals(HttpMethod.GET)) {
			JsonObject employeeResObj = ((JsonObject) jsonParser.parse(employeeResponse.asString()).getAsJsonObject());
			jsonSchemaValidator.validateResponseAgainstSchema(employeeResObj.toString(), schemaFile);

		}

	}

}
