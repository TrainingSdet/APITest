package com.framework.employeevalidators;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.framework.common.Configuration;
import com.framework.pojo.Employee;

import org.testng.Assert;

public class DBValidator {

	Configuration configuration = Configuration.getInstance();

	public void validateDB(int employeeId) throws SQLException {

		Connection conn = configuration.getDbConnecton();
		Employee employee = configuration.getEmployee();

		Statement stmt = conn.createStatement();
		ResultSet employeeRS = stmt.executeQuery("SELECT * FROM USERS WHERE USER_ID='" +employeeId+"'");
		ResultSet employeeDepartmentsRS = stmt.executeQuery("SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_NAME=" + employee.getEmpDept() + "'");
		ResultSet employeeStatuRS = stmt.executeQuery("SELECT * FROM USERS_STATUS WHERE USER_STATUS='" + employee.getEmpStatus() + "'");
		ResultSet employeeDesignationRS = stmt
				.executeQuery("SELECT * FROM USERS_DESIGNATION WHERE USER_DESIGNATION='" + employee.getEmpDesignation() + "'");
		ResultSet employeeTypeRS = stmt
				.executeQuery("SELECT * FROM USERS_TYPE WHERE USER_TYPE_NAME='" + employee.getEmpType() + "'");

		while (employeeRS.next()) {

			if (employeeTypeRS.getInt("USER_TYPE_ID") != employeeRS.getInt("USER_TYPE_ID")) {
				Assert.fail("DB Validation : Invalid UserType Id");
			}
			if (employeeDepartmentsRS.getInt("DEPARTMENT_ID") != employeeRS.getInt("DEPARTMENT_ID")) {
				Assert.fail("Invalid Department Id");
			}
			if (employeeStatuRS.getInt("USER_STATUS_ID") != employeeRS.getInt("USER_STATUS_ID")) {
				Assert.fail("Invalid StaDB Validation : tus Id");
			}
			if (employeeDesignationRS.getInt("USER_DESIGNATION_ID") != employeeRS.getInt("USER_DESIGNATION_ID")) {
				Assert.fail("DB Validation : Invalid Designation Id");
			}
			if (!employee.getEmpDOB().equals(employeeRS.getString("USER_DOB"))) {
				Assert.fail("DB Validation : Invalid DOB");
			}
			if (!employee.getEmpDOJ().equals(employeeRS.getString("USER_DOJ"))) {
				Assert.fail("DB Validation :Invalid DOJ");
			}
			if (employee.getEmpDOE() != null || !employee.getEmpDOE().isEmpty()) {
				if (!employee.getEmpDOE().equals(employeeRS.getString("USER_DOE"))) {
					Assert.fail("DB Validation : Invalid DOE");
				}
			}
			if (!employee.getEmpFirstName().equals(employeeRS.getString("USER_FIRST_NAME"))) {
				Assert.fail("DB Validation : Invalid FirstName");
			}
			if (!employee.getEmpLastName().equals(employeeRS.getString("USER_LAST_NAME"))) {
				Assert.fail("DB Validation : Invalid LastName");
			}
			if (employee.getEmpSalary() != employeeRS.getInt("USER_SALARY")) {
				Assert.fail("DB Validation : Incorrect Salary");
			}
			if (!employee.getEmpAddress().equals(employeeRS.getString("USER_ADDRESS"))) {
				Assert.fail("DB Validation : Invalid Address");
			}
			if (!employee.getEmpEmailId().equals(employeeRS.getString("USER_EMAIL_ID"))) {
				Assert.fail("DB Validation : Invalid EmailId");
			}
			if (!employee.getEmpLoginName().equals(employeeRS.getString("USER_LOGIN_NAME"))) {
				Assert.fail("DB Validation : Invalid LoginName");
			}
			if (!employee.getEmpLoginPassword().equals(employeeRS.getString("USER_LOGIN_PASSWORD"))) {
				Assert.fail("DB Validation : Invalid LoginPassword");
			}
			if (employee.getEmpLoginPassword() != employeeRS.getString("USER_SUPERVISOR_ID")) {
				Assert.fail("DB Validation : Invalid SuperVisorId");
			}

		}

	}

}
