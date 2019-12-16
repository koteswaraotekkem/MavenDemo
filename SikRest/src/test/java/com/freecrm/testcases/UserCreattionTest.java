package com.freecrm.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.CRMTestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage1;
import com.freecrm.pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserCreattionTest extends CRMTestBase {
//crl+shift+o
	String currentMethodName;
	ExtentReports reports ;
	ExtentTest testSteps;
	@BeforeClass
	public void beforeClassInTest() {
		System.out.println("CopyOfCreateUserTest");
		initDriver();
		reports =  new ExtentReports("E\\AutomationReport\\FreeCRM-TestAutomationReport.html", true);
	}
	//Extent Rep, maven reports, ATU Records

	@BeforeMethod
	public void runbeforeMethod(Method method){
		currentMethodName = method.getName();
		testSteps = reports.startTest(getCurrentClassName()+currentMethodName);
		System.out.println("----------------------------------------------------");
		System.out.println("Starting the Test method "+ getCurrentClassName()+currentMethodName);
		System.out.println("----------------------------------------------------");
		
		 
		
	}

	private String getCurrentClassName(){
		return this.getClass().getSimpleName();
	}
	
	@Test(priority = 0, description = "creating Super User", groups = "smoke")
	public void createSuperUser_UserCreattionTest() {
		LoginPage1 loginObj = new LoginPage1();
		testSteps.log(LogStatus.PASS, "Succsfully logged in");
		HomePage homepage = loginObj.loginAsSuperUser();
		
		testSteps.log(LogStatus.PASS, homepage.getHomePageTitle());
		System.out.println(homepage.getHomePageTitle());
		driver.switchTo().frame("mainpanel");
		homepage.verifyHomePageDetails();
		ReportsPage reportsPAge = homepage.openReports();
		reportsPAge.verifyCallReports();
		testSteps.log(LogStatus.PASS, "Reports apge opened");
		driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[15]/a")).click();
		homepage.openCalanderPage();
		System.out.println("create super user ");
		//Assert.assertEquals(33, 334, "actaul nd expced are not same");
		driver.switchTo().defaultContent();
		testSteps.log(LogStatus.PASS, "Moved to def frame");
	}

	@Test(priority = 1, description = "createSupAdmin  erU  ser", enabled = true)
	public void createAdminUser_UserCreattionTest() {
		//, retryAnalyzer = com.pack.capam.utils.RetryAnalyzer.class)
		System.out.println("createAdminUsercreateAdminUser");
	}
	
	@AfterMethod
	public void afterMethod(){
		reports.endTest(testSteps);
		
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("closin gthe browser");
		driver.quit();
		reports.flush();
	}

}
