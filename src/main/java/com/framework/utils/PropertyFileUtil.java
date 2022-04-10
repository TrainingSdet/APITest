package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.testng.Reporter;

public class PropertyFileUtil {

	OutputStream output = null;

	Properties loadedProperties = new Properties();

	public void createPropertyFile(String filePath) {
		try {
			File file = new File(filePath);
			file.setReadable(true);
			file.setWritable(true);
			output = new FileOutputStream(filePath);
		} catch (Exception io) {
			System.out.print("Exception in createPropertyFile(1P)::" + filePath);
			Reporter.log("Exception in createPropertyFile(1P)::" + filePath);
			io.printStackTrace();
		}

	}

	

	public Properties loadParameters(String configFile) {
		Properties prop = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(configFile);
			prop.load(inputStream);
		} catch (Exception e) {
			try {
				prop.load(PropertyFileUtil.class.getResourceAsStream("/" + configFile));
			} catch (IOException e1) {
				System.out.println("Exception while loading properties file:::" + configFile);
				Reporter.log("Exception while loading properties file:::" + configFile);
				e1.printStackTrace();
			}
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.print("Exception in loadParameters(1P)::" + configFile);
					Reporter.log("Exception in loadParameters(1P)::" + configFile);
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

	public List<String> loadFileAsList(String filePath) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filePath));
		List<String> list = new ArrayList<String>();
		while (s.hasNextLine()) {
			list.add(s.nextLine());
		}
		s.close();
		return list;
	}
}
