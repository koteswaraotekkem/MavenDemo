package com.freecrm.base;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.freecrm.util.DeviceAccessOperations;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CRMTestBase  extends DeviceAccessOperations{
	public static WebDriver driver;
	public static Properties prop;
	static String userWorkingDir = System.getProperty("user.dir");
	private static String OS = System.getProperty("os.name").toLowerCase();
	//public ExtentReports reports;
	//public ExtentTest testSteps;
	
	@BeforeClass
	public void befrClass(){
		//reports = new ExtentReports("E:\\AutomationReport\\FreeCRM-Automation_Report.html", true);
		
	}  
	
	@BeforeMethod
	public void runbeforeMethod(Method method){
		//testSteps = reports.startTest(getTestClassName()+"."+method.getName());
		
	}
	 public String getTestClassName() {
	        return this.getClass().getSimpleName();
	    }
	
	static{
		System.out.println(OS);
		prop = new Properties();

		try {
			System.out.println(userWorkingDir);
			FileInputStream fis = new FileInputStream(userWorkingDir +"\\externalFiles\\propertyFiles\\"
					+ "\\configuration.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public WebDriver initDriver() {
		if (prop.getProperty("browser").toString().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", userWorkingDir+"\\externalFiles\\drivers\\chromedriver98\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("destinationHost"));
		return driver;
	}
	
	

}
