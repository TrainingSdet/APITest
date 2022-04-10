package com.framework.employeevalidators;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;

import io.restassured.response.Response;

public class JsonSchemaValidator {

	//JsonParser jsonParser = new JsonParser();

	public void validateResponseAgainstSchema(String employeeResponse, String schemaFile) {
		JSONObject jsonSchema = new JSONObject(new JSONTokener(JsonSchemaValidator.class
				.getResourceAsStream("/TestData" + File.separator + "CSVFiles" + File.separator + "SchemaFiles"
						+ File.separator + schemaFile)));
		JSONObject jsonSubject = new JSONObject(new JSONTokener(employeeResponse));
		Schema schema = SchemaLoader.load(jsonSchema);
		try {
			schema.validate(jsonSubject);
		} catch (ValidationException e) {
			Assert.fail(e.getMessage());
		}
	}

}
