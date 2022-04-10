package com.framework.common;

import java.sql.SQLException;
import java.util.Properties;

import org.databene.feed4testng.FeedTest;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.framework.pojo.JDBCInfo;
import com.framework.utils.DBUtil;
import com.framework.utils.PropertyFileUtil;

public class Base extends FeedTest {
	
	protected Logger logger;	
	private static Properties configProperties = new Properties();
	private static JDBCInfo jdbcInfo;
	
	public Base() {
		this.logger = LoggerFactory.getLogger((Class) Base.class);
	}
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "configurationFile","apiVersion"})
	public void setUpTest(@Optional("employee.properties") final String configFile,@Optional("1.1") final String apiVersion)
			throws Exception {
		
		this.logger.info("*********** SETTING UP AUTOMATION TEST ENVIRONMENT ********************");
		
		setEnvironmentDefaults(configFile,apiVersion);		
		init(configFile);
		
	}
	
	public void setEnvironmentDefaults(String configFile,String apiVersion) {
		
		if (configFile.isEmpty()) {
			configFile = "employee.properties";
		}
		if (apiVersion.isEmpty()) {
			apiVersion = "1.0";
		}
		final Configuration configurationObj = Configuration.getInstance();
		configurationObj.setApiVersion(apiVersion);
	}
	
	protected static void init(String configFile) throws JoseException, SQLException {
		
		PropertyFileUtil propertyfileUtil = new PropertyFileUtil();
		configProperties = propertyfileUtil.loadParameters(configFile);
		Configuration configurationObj = Configuration.getInstance();
		configurationObj.setUrlEncoding(configProperties.getProperty("URL_ENCODING"));
		if (configProperties.getProperty("PORT") != null && !configProperties.getProperty("PORT").isEmpty()
				&& configProperties.getProperty("BASE_URI")!=null && !configProperties.getProperty("BASE_URI").isEmpty()) {
			configurationObj.setApiUrlBasePath(configProperties.getProperty("BASE_URI") + ":"
					+ Integer.parseInt(configProperties.getProperty("PORT")));
		} else {
			System.out.println("Invalid OR Empt BASE_URI Or PORT - > Please Check "+configFile);
		}
		
		if (configProperties.getProperty("JDBCSERVER") != null && !configProperties.getProperty("JDBCSERVER").isEmpty() 
				&& configProperties.getProperty("JDBCPORT") != null && !configProperties.getProperty("JDBCPORT").isEmpty()) {
			jdbcInfo = new JDBCInfo();
			jdbcInfo.setJdbcServer(configProperties.getProperty("JDBCSERVER"));
			jdbcInfo.setJdbcPort(configProperties.getProperty("JDBCPORT"));
			jdbcInfo.setJdbcId(configProperties.getProperty("JDBCID"));
			jdbcInfo.setJdbcType(configProperties.getProperty("JDBCTYPE"));
			jdbcInfo.setPassword(configProperties.getProperty("PASSWORD"));
			jdbcInfo.setUserName(configProperties.getProperty("PASSWORD"));
			configurationObj.setJdbcInfo(jdbcInfo);
			configurationObj.setDbConnecton(DBUtil.getOracleDBConnection(configurationObj.getJdbcInfo()));			
		}
		
	}
	
	
	
	
}
