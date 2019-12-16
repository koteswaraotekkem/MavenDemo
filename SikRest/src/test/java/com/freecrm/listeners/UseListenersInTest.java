package com.freecrm.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.freecrm.listeners.ListernersDemo.class)
public class UseListenersInTest {

	
	@Test(retryAnalyzer=com.freecrm.listeners.RunFailedTests.class)
	public void testcase001(){
		System.out.println("testcase001");
	}
	@Test(retryAnalyzer=com.freecrm.listeners.RunFailedTests.class)
	public void testcase002(){
		System.out.println("testcase002testcase002testcase002testcase002testcase002testcase002");
		Assert.fail();
		
	}
	
	@Test
	public void testcase003(){
		System.out.println("testcase003");
	}
}
