package com.pack.capam.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	    private static final int MAX_POSSIBLE_RETRIES = 3;
	    private int retryCount = 0;
	
	  public boolean retry(ITestResult result) {
	       System.out.println(("Test method '" + result.getMethod().getMethodName() + "' has failed."));
	        if (retryCount < MAX_POSSIBLE_RETRIES) {
	            System.out.println(("Will try to relaunch it."));
	            retryCount++;
	            return true;
	        }
	        return false;
	    }

}
