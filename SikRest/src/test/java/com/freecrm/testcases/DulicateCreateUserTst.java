package com.freecrm.testcases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static org.testng.Assert.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freecrm.base.CRMTestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage1;
import com.freecrm.pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DulicateCreateUserTst extends CRMTestBase {
		public ExtentReports reports;
		public ExtentTest testSteps;
		public String freeCRMTitle = "CRMPRO - CRM software for customer relationship management, sales, and support.";
		String str= null;
		
	@BeforeClass
	public void beforeClassInTest(){
		 //initDriver();
		//reports = new ExtentReports(reportsPath+ "FreeCRM-Automation_Report.html", true);
	/*	
		int a=34;
		int b=23;
		
	boolean conditions = 	freeCRMTitle.contains("CRM") &&
		freeCRMTitle.endsWith("support.") &&
		freeCRMTitle.startsWith("CRMP");
		
	Assert.assertTrue(conditions);
	*/ 
		//ctr+sh+fwdslsh
	
	SoftAssert sofasssert = new SoftAssert();
	
	sofasssert.assertEquals(33, 55, "valis not matching");
	sofasssert.assertEquals(223, 55, "abc vnvv vnc");

	sofasssert.assertEquals("rVI", "ANAD", "");
	
	sofasssert.assertTrue(true);
	
	sofasssert.assertAll();
	
	System.out.println("dfdsf");
	
	assertTrue(false);
		
	}
	@BeforeMethod
	public void runbeforeMethod(Method method){
		testSteps = reports.startTest(getTestClassName()+method.getName());
		
	}
	
	@Test(priority=0, description="creating Super User", groups="smoke")
	public void createSuperUser_CopyOfCreateUserTst(){
		testSteps.log(LogStatus.PASS, " Started test class");
		LoginPage1 loginObj = new LoginPage1();
		assertNull(loginObj, "Problem with Login Page, please checkin it");
		String titiel = loginObj.getHomePageTititle();
		
		assertFalse(loginObj.isUserNameDispalyed(), "Username is not displayed in home page");
		
		assertEquals(titiel, freeCRMTitle, "Not matching the titlte");
		
		
		testSteps.log(LogStatus.PASS, " Opened crm login page");
		HomePage homepage =loginObj.loginAsSuperUser();
		testSteps.log(LogStatus.PASS, " Records are added");
		System.out.println(homepage.getHomePageTitle());
		
		//driver.get(driver.getCurrentUrl());
		//driver.findElement(By.className("sss")).sendKeys(Keys.F5);
		driver.navigate().back();
		driver.navigate().forward();
		driver.switchTo().frame("mainpanel");
		
		homepage.verifyHomePageDetails();
		ReportsPage reportsPAge = homepage.openReports();
		testSteps.log(LogStatus.PASS, "Reports page Opened");
		reportsPAge.verifyCallReports();
		testSteps.log(LogStatus.FAIL, "call Reports Displayed");
		
		driver.findElement(By.xpath("//*[@id='navmenudvvvvv']/ul/li[15]/a")).click();
		homepage.openCalanderPage();
		System.out.println("create super user ");
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=1, description="createSupAdmin  erU  ser", enabled= true)
	public void createAdminUser_CopyOfCreateUserTst(){
		System.out.println("createAdminUsercreateAdminUser");
	}
	
	@Test(priority=1, description="createSupAdmin  erU  ser", enabled= true, dependsOnMethods="createAdminUser_CopyOfCreateUserTst")
	public void pleaseSkipME(){
		System.out.println("a");
	}
	public String destImagePath = "E:\\AutomationReport\\";
	
	public String captureScreenShot(String screenshotNmae){
		TakesScreenshot takeImage = (TakesScreenshot)driver;
		File sourceImagePath = takeImage.getScreenshotAs(OutputType.FILE);
		String destImg = destImagePath+screenshotNmae +".jpeg";
		File dest = new File(destImg);
		
		try {
			FileUtils.copyFile(sourceImagePath, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destImg;
		
		
	}
	
	
	@AfterClass
	public void closeBrowser(){
		System.out.println("closin gthe browser");
		driver.quit();
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			String storedImg  = captureScreenShot(result.getName());
			String testStepImg = testSteps.addScreenCapture(storedImg);
			testSteps.log(LogStatus.FAIL, result.getInstanceName(), testStepImg);
		}
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			captureScreenShot(result.getName());
		}
		reports.endTest(testSteps);
		reports.flush();
	}
		
}


