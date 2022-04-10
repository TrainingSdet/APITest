package com.framework.common;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.pojo.Employee;
import com.framework.pojo.JDBCInfo;

import lombok.Getter;
import lombok.Setter;

/*@Getter
@Setter*/
public class Configuration {

	
	private static Logger logger = LoggerFactory.getLogger(Configuration.class);
	private String apiVersion;
	private String urlEncoding;
	private String apiUrlBasePath;
	private String jdbcServer;
	private String jdbcPort;
	private String jdbcId;
	private String jdbcType;
	private Connection dbConnecton;	
	private int getAPITimeout;
	private int updateAPITimeout;
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getUpdateAPITimeout() {
		return updateAPITimeout;
	}
	public void setUpdateAPITimeout(int updateAPITimeout) {
		this.updateAPITimeout = updateAPITimeout;
	}
	public int getGetAPITimeout() {
		return getAPITimeout;
	}
	public void setGetAPITimeout(int getAPITimeout) {
		this.getAPITimeout = getAPITimeout;
	}
	private JDBCInfo jdbcInfo = new JDBCInfo();
	

	private static Configuration instance = null;
	
	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}
	private Configuration() {

		System.out.println("Setting Configurations for the API Test environment.........................");
	}
	public String getUrlEncoding() {
		return urlEncoding;
	}

	public void setUrlEncoding(String urlEncoding) {
		this.urlEncoding = urlEncoding;
	}

	public String getApiUrlBasePath() {
		return apiUrlBasePath;
	}

	public void setApiUrlBasePath(String apiUrlBasePath) {
		this.apiUrlBasePath = apiUrlBasePath;
	}

	public String getJdbcServer() {
		return jdbcServer;
	}

	public void setJdbcServer(String jdbcServer) {
		this.jdbcServer = jdbcServer;
	}

	public String getJdbcPort() {
		return jdbcPort;
	}

	public void setJdbcPort(String jdbcPort) {
		this.jdbcPort = jdbcPort;
	}

	public String getJdbcId() {
		return jdbcId;
	}

	public void setJdbcId(String jdbcId) {
		this.jdbcId = jdbcId;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

		
	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	public JDBCInfo getJdbcInfo() {
		return jdbcInfo;
	}
	public void setJdbcInfo(JDBCInfo jdbcInfo) {
		this.jdbcInfo = jdbcInfo;
	}
	
	public Connection getDbConnecton() {
		return dbConnecton;
	}
	public void setDbConnecton(Connection dbConnecton) {
		this.dbConnecton = dbConnecton;
	}
	
}
