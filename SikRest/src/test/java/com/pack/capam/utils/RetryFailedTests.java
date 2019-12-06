package com.pack.capam.utils;

import org.testng.ITestResult;

public class RetryFailedTests {
 int maxRetries=3;
 int counter=0;
	public boolean retry(ITestResult result){
		if (result.getStatus() == ITestResult.FAILURE) {
			if (counter < maxRetries) {
				counter++;
				return true;
			}
			
		}
		return false;
	}
	
}
