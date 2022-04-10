package com.framework.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.pojo.JDBCInfo;

import oracle.jdbc.pool.OracleDataSource;

public class DBUtil {

	protected static Logger logger = LoggerFactory.getLogger(DBUtil.class);
	static OracleDataSource oracleDS = null;
	 
    
    
	public static Connection getOracleDBConnection(JDBCInfo jdbcConnectionInfo) throws SQLException {		
	    	
		oracleDS = new OracleDataSource();
		oracleDS.setURL("jdbc:oracle:thin:@"+jdbcConnectionInfo.getJdbcServer()+":"+Integer.parseInt(jdbcConnectionInfo.getJdbcPort())+":xe");
		oracleDS.setUser(jdbcConnectionInfo.getUserName());
		oracleDS.setPassword(jdbcConnectionInfo.getPassword());
		if(oracleDS.getConnection()==null) {
			logger.info("Database connection is FAILED "+jdbcConnectionInfo);
		}else {
			logger.info("Database connection is SUCCESS");
		}
		return oracleDS.getConnection()!=null?oracleDS.getConnection():null;
		
	}
}
