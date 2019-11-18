package com.users.User;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.casso.cassobasepackage.CaTestBase;

public class CreateUserTests extends CaTestBase {

	
	@BeforeClass
	public void beforeClass() {
		driver.get("https://igbc.in/igbc");
	}
	@Test(priority=0)
	public void createTempUser() {
		STEP_INFO("1", "Enter user value for createTempUser", " Values should accepted createTempUser");
		logger.info(driver.getTitle());
	}
	
	@Test(priority=1)
	public void createAdminUser() {
		STEP_INFO("1", "Enter user value for createAdminUser", " Values should accepted createAdminUser");
		logger.info(driver.getPageSource());
		
	}
	
	@Test(priority=2)
	public void createSuperUser() {
		STEP_INFO("1", "Enter user value for createSuperUser", " Values should accepted createSuperUser");
		
	}
	
	@Test(priority=3)
	public void createGlobalUser() {
		STEP_INFO("1", "Enter user value for createGlobalUser", " Values should accepted createGlobalUser");
		driver.quit();
	}
}
