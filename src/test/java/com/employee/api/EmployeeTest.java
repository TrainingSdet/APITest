package com.employee.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.databene.benerator.anno.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.common.Base;
import com.framework.common.Configuration;
import com.framework.constants.HttpMethod;
import com.framework.helper.EmployeeGenerics;
import com.framework.helper.EmployeeHelper;
import com.framework.pojo.HttpMethodParameters;
import com.framework.utils.CommonUtils;
import com.framework.utils.EmployeeUtil;

import io.restassured.response.Response;

public class EmployeeTest extends Base {
	
	protected Logger logger = LoggerFactory.getLogger(EmployeeTest.class);	
	EmployeeUtil employeeUtil = new EmployeeUtil();
	EmployeeHelper employeeHelper = new EmployeeHelper();
	HttpMethodParameters httpParams = new HttpMethodParameters();
	HashMap<String, String> addHeaders = new HashMap<String, String>();
	HashMap<String,ArrayList<String>> negativeExpectedValuesMap;
	EmployeeGenerics employeeGenerics = new EmployeeGenerics();
	final String addEmployeeSchema = "AddEmployeeSchema.json";
	final String editEmployeeSchema = "EditEmployeeSchema.json";
	final String commonNegativeScenariFile = "EmployeeNegativeTestScenarios.json";
	
	@BeforeClass
	public void setUp() {
		negativeExpectedValuesMap = employeeHelper.readNegativeExpectedValues(commonNegativeScenariFile);
	}
	

	public void setUpHeaders(String signedInUserId,String signedInUserPassword) {
		addHeaders = new HashMap<String, String>();
		addHeaders.put("Content-Type", "application/json");
		addHeaders.put("loginUserId", signedInUserId);
		addHeaders.put("loginUserPassword", signedInUserPassword);
		httpParams.setAddHeaders(addHeaders);
	}

	@Test(enabled = false, dataProvider = "feeder")
	@Source("\\TestData\\CSVFiles\\Employee\\AddEmployee.csv")
	public void testAddEmployeePositive(String testCaseId,String testDescription,String loggedInUserId,String loggedInUserPassword,String empOrgId,String empType,String	empDept,String empFirstName,
			String empLastName,String empSalary,String	empDOB,String empDOJ,String	empDOE,String empAddress,
			String empDesignation,String empStatus,String empEmailId,String	empLoginName,String	empLoginPassword,
			String empSupervisorId,int statusCode,String testCaseEnabled) throws SQLException {
		
		logger.info("Executing Testcases for Add Employee --->"+testCaseId);
		CommonUtils.isTCEnabled(testCaseId, testCaseEnabled);
		setUpHeaders(loggedInUserId,loggedInUserPassword);
		String createEmpBodyParam = employeeHelper.constructCreateEmployeePayload(empOrgId, empType, empDept, empFirstName, empLastName, empSalary, empDOB, empDOJ, empDOE, empAddress, empDesignation, empStatus, empEmailId, empLoginName, empLoginPassword, empSupervisorId);
		httpParams.setBodyParams(createEmpBodyParam);
		httpParams.setHttpMethod("POST");
		Response employeeResponse = employeeUtil.onBoardEmployee(httpParams, null);
		employeeGenerics.verifyEmployeeApiResponse(testCaseId, HttpMethod.POST, employeeResponse, "",null, statusCode, addEmployeeSchema, "ALL");		
	}
	
	
	@Test(enabled = false, dataProvider = "feeder")
	@Source("\\TestData\\CSVFiles\\Employee\\UpdateEmployee.csv")
	public void testUpdateEmployee(String testCaseId,String testDescription,String loggedInUserId,String loggedInUserPassword,int updateEmpId,String empOrgId,String empType,String	empDept,String empFirstName,
			String empLastName,String empSalary,String	empDOB,String empDOJ,String	empDOE,String empAddress,
			String empDesignation,String empStatus,String empEmailId,String	empLoginName,String	empLoginPassword,
			String empSupervisorId,int statusCode,String testCaseEnabled) throws SQLException {
		logger.info("Executing Testcases for Update Employee--->"+testCaseId);
		CommonUtils.isTCEnabled(testCaseId, testCaseEnabled);
		setUpHeaders(loggedInUserId,loggedInUserPassword);
		String createEmpBodyParam = employeeHelper.constructCreateEmployeePayload(empOrgId, empType, empDept, empFirstName, empLastName, empSalary, empDOB, empDOJ, empDOE, empAddress, empDesignation, empStatus, empEmailId, empLoginName, empLoginPassword, empSupervisorId);
		httpParams.setBodyParams(createEmpBodyParam);
		httpParams.setHttpMethod("PATCH");
		LinkedHashMap<String, Object> pathParam =new LinkedHashMap<>(); 
		pathParam.put("employeeId", updateEmpId);
		httpParams.setPathParams(pathParam);
		Response updateResponse = employeeUtil.updateEmployee(httpParams, null);
		employeeGenerics.verifyEmployeeApiResponse(testCaseId, HttpMethod.PATCH, updateResponse, "",null, statusCode, addEmployeeSchema, "");
	}
	
	
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\TestData\\CSVFiles\\Employee\\FetchEmployee.csv")
	public void testGetEmployee(String testCaseId,String testDescription,String loggedInUserId,String loggedInUserPassword,String includeFilter,String employeeIdFilter,String schemaFile,int statusCode,String testCaseEnabled) throws SQLException {
		logger.info("Executing Testcases for GET Employee--->"+testCaseId);
		CommonUtils.isTCEnabled(testCaseId, testCaseEnabled);
		setUpHeaders(loggedInUserId,loggedInUserPassword);		
		httpParams.setHttpMethod("GET");
		HashMap<String, Object> employeeFilters = new HashMap<>();
		if(!includeFilter.isEmpty())
			employeeFilters.put("include", includeFilter);
		if(!employeeIdFilter.isEmpty())
			employeeFilters.put("include", Integer.parseInt(employeeIdFilter));
		httpParams.setQueryParams(employeeFilters);
		Response getResponse = employeeUtil.getEmployees(httpParams, null);
		employeeGenerics.verifyEmployeeApiResponse(testCaseId, HttpMethod.GET, getResponse, "",null, statusCode, addEmployeeSchema, schemaFile);
	}
	
}
