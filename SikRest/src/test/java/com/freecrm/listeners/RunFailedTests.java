package com.freecrm.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RunFailedTests implements IRetryAnalyzer {

	int retryCount =0;
	final int  MAX_RETRY_COUNT=3;
	
	public boolean retry(ITestResult result) {
		if (retryCount<MAX_RETRY_COUNT) {
			retryCount++;
			return true;
		}
		
		return false;
	}
	
	
}
