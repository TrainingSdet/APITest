package com.framework.helper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.framework.common.Configuration;
import com.framework.pojo.Employee;
import com.framework.pojo.EmployeeRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class EmployeeHelper {
	
	JsonParser jsonParser = new JsonParser();
	Configuration configuration = Configuration.getInstance();
	
	public String constructCreateEmployeePayload(String empOrgId,String empType,String	empDept,String empFirstName,
			String empLastName,String empSalary,String	empDOB,String empDOJ,String	empDOE,String empAddress,
			String empDesignation,String empStatus,String empEmailId,String	empLoginName,String	empLoginPassword,
			String empSupervisorId) {
		
		EmployeeRequest createEmpRequest = new EmployeeRequest();
		Employee newEmployee = new Employee();
		Gson gson = new Gson();
		
		if(!empOrgId.isEmpty()) {
			newEmployee.setEmpOrgId(Integer.parseInt(empOrgId));
		}
		if(!empType.isEmpty()) {
			newEmployee.setEmpType(empType);
		}
		if(!empDept.isEmpty()) {
			newEmployee.setEmpDept(empDept);
		}
		if(!empFirstName.isEmpty()) {
			newEmployee.setEmpFirstName(empFirstName);
		}
		if(!empLastName.isEmpty()) {
			newEmployee.setEmpLastName(empLastName);
		}
		if(!empSalary.isEmpty()) {
			newEmployee.setEmpSalary(Integer.parseInt(empSalary));
		}
		if(!empDOB.isEmpty()) {
			String[]  dob = empDOB.split("-");
			String formatedDob = dob[2]+"-"+dob[1]+"-"+dob[0];
			newEmployee.setEmpDOB(formatedDob);
		}
		if(!empDOJ.isEmpty()) {
			String[]  doj = empDOJ.split("-");
			String formatedDoj = doj[2]+"-"+doj[1]+"-"+doj[0];
			newEmployee.setEmpDOJ(formatedDoj);
		}
		if(!empDOE.isEmpty()) {
			String[]  doe = empDOE.split("-");
			String formatedDoe = doe[2]+"-"+doe[1]+"-"+doe[0];
			newEmployee.setEmpDOE(formatedDoe);
		}
		if(!empAddress.isEmpty()) {
			newEmployee.setEmpAddress(empAddress);
		}
		if(!empDesignation.isEmpty()) {
			newEmployee.setEmpDesignation(empDesignation);
		}
		if(!empStatus.isEmpty()) {
			newEmployee.setEmpStatus(empStatus);
		}
		if(!empEmailId.isEmpty()) {
			newEmployee.setEmpEmailId(empEmailId);
		}
		if(!empLoginName.isEmpty()) {
			newEmployee.setEmpLoginName(empLoginName);
		}
		if(!empLoginPassword.isEmpty()) {
			newEmployee.setEmpLoginPassword(empLoginPassword);
		}
		if(!empSupervisorId.isEmpty()) {
			newEmployee.setEmpSupervisorId(Integer.parseInt(empSupervisorId));
		}
		createEmpRequest.setEmployee(newEmployee);
		configuration.setEmployee(newEmployee);
		String employeeRequestPayload = gson.toJson(createEmpRequest);
		System.out.println("Create Employee Payload -> "+employeeRequestPayload);
		return employeeRequestPayload;
	}

	
	public HashMap<String, ArrayList<String>> readNegativeExpectedValues(String negScenariosFile) {
		HashMap<String, ArrayList<String>> negativeTestValuesMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String> negativeTestList;
		try {

			JsonArray negativeTestsArr = (JsonArray) jsonParser.parse(new FileReader(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\TestData\\CSVFiles\\NegativeTestScenarios\\"+negScenariosFile));
			for (Object negativeTest : negativeTestsArr) {
				negativeTestList = new ArrayList<>();
				JsonObject negativeExpense = (JsonObject) negativeTest;
				String negativeTestScenario = negativeExpense.get("negativeTestScenario").getAsString();
				String statusCode = negativeExpense.get("httpStatusCode").getAsString();
				String errorMessage = negativeExpense.get("errorMessage").getAsString();				
				negativeTestList.add(statusCode);
				negativeTestList.add(errorMessage);
				negativeTestValuesMap.put(negativeTestScenario, negativeTestList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return negativeTestValuesMap;
	}
	
	
	
}
