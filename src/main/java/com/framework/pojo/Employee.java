package com.framework.pojo;

public class Employee {

	
	private Integer empOrgId;
	private String empType;
	private String empDept;
	private String empDesignation;
	private String empStatus;
	private String empFirstName;
	private String empLastName;
	private Integer empSalary;
	private String empDOB;
	private String empDOJ;
	private String empDOE;
	private String empAddress;
	private String empEmailId;
	private String empLoginName;
	private String empLoginPassword;
	private Integer empSupervisorId;
	
	
	
	public Integer getEmpOrgId() {
		return empOrgId;
	}
	public void setEmpOrgId(Integer empOrgId) {
		this.empOrgId = empOrgId;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public Integer getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}
	public String getEmpDOJ() {
		return empDOJ;
	}
	public void setEmpDOJ(String empDOJ) {
		this.empDOJ = empDOJ;
	}
	public String getEmpDOE() {
		return empDOE;
	}
	public void setEmpDOE(String empDOE) {
		this.empDOE = empDOE;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	public String getEmpLoginName() {
		return empLoginName;
	}
	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}
	public String getEmpLoginPassword() {
		return empLoginPassword;
	}
	public void setEmpLoginPassword(String empLoginPassword) {
		this.empLoginPassword = empLoginPassword;
	}
	public Integer getEmpSupervisorId() {
		return empSupervisorId;
	}
	public void setEmpSupervisorId(Integer empSupervisorId) {
		this.empSupervisorId = empSupervisorId;
	}
	
	@Override
	public String toString() {
		return "Employee [empOrgId=" + empOrgId + ", empType=" + empType + ", empDept=" + empDept + ", empDesignation="
				+ empDesignation + ", empStatus=" + empStatus + ", empFirstName=" + empFirstName + ", empLastName="
				+ empLastName + ", empSalary=" + empSalary + ", empDOB=" + empDOB + ", empDOJ=" + empDOJ + ", empDOE="
				+ empDOE + ", empAddress=" + empAddress + ", empEmailId=" + empEmailId + ", empLoginName="
				+ empLoginName + ", empLoginPassword=" + empLoginPassword + ", empSupervisorId=" + empSupervisorId
				+ "]";
	}
	
}
