package com.framework.pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class JDBCInfo {

	private String jdbcServer;
	  private String jdbcPort;
	  private String jdbcId;
	  private String jdbcType;
	  private String userName;
	  private String password;
	  
	  
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	  @Override
	public String toString() {
		return "JDBCInfo [jdbcServer=" + jdbcServer + ", jdbcPort=" + jdbcPort + ", jdbcId=" + jdbcId + ", jdbcType="
				+ jdbcType + ", userName=" + userName + ", password=" + password + "]";
	}
}
