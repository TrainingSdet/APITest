package com.framework.utils;

import org.testng.Reporter;
import org.testng.SkipException;

public class CommonUtils {

	public static void isTCEnabled(String testCaseId,String enabled) {
		if ("false".equalsIgnoreCase(enabled)) {
			Reporter.log("Skipping Testcase:" + testCaseId);
			throw new SkipException("Skipping Test  --> " + testCaseId);
		}
	}
}
