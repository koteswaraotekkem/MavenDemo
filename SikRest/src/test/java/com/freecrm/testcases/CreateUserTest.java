package com.freecrm.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.freecrm.base.CRMTestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage1;
import com.freecrm.pages.ReportsPage;

public class CreateUserTest extends CRMTestBase {
	@BeforeClass
	public void beforeClassInTest(){
		System.out.println("beforeClassInTest");
	}
	
	@BeforeClass
	public void runbeforeMethod(){
		System.out.println("runbeforeMethod");
		initDriver();
	}
	
	@Test(priority=0, description="creating Super User", groups="smoke")
	public void createSuperUser(){
		LoginPage1 loginObj = new LoginPage1();
		HomePage homepage =loginObj.loginAsSuperUser();
		System.out.println(homepage.getHomePageTitle());
		driver.switchTo().frame("mainpanel");
		
		homepage.verifyHomePageDetails();
		ReportsPage reportsPAge = homepage.openReports();
		reportsPAge.verifyCallReports();
		
	driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[15]/a")).click();
		homepage.openCalanderPage();
		System.out.println("create super user ");
		Assert.assertEquals(33, 33, "actaul nd expced are not same");
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=1, description="createSupAdmin  erU  ser", enabled= true, dependsOnMethods="createSuperUser")
	public void createAdminUser(){
		System.out.println("createAdminUsercreateAdminUser");
	}
	
	@AfterClass
	public void closeBrowser(){
		System.out.println("closin gthe browser");
		driver.quit();
	}
	
	
}


