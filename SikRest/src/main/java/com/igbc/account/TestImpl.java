package com.igbc.account;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pack.capam.utils.RetryAnalyzer;

public class TestImpl {

	
	@Test(description="Create account with normal account access", enabled=true, priority=1,retryAnalyzer = RetryAnalyzer.class)
	public void creteUserAccountTest() {
		System.out.println("***********************");
		Assert.assertTrue(false);
	}
	
}
