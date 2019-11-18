package com.casso.cassobasepackage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CaTestBase {
	public WebDriver driver;
	public static Properties props;
	public String currentDir = System.getProperty("user.dir");
	public static final Logger logger = LoggerFactory.getLogger(CaTestBase.class);
	
	@BeforeSuite
	public void beforeSuite(){
		logger.info("Initializing the driver");
		intitDriver();
	}

	{

		props = new Properties();
		try {
			logger.info("Loading configuration properties File");

			FileInputStream fis = new FileInputStream(currentDir + "\\src\\configuration.properties");
			props.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
		

	}

	public void intitDriver() {
		logger.info("Browser is :: " + props.getProperty("browser"));
		if (props.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					currentDir + "//externalFiles//drivers//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} else {
			System.out.println("");
		}
	}
	
	 public void STEP_INFO(String stepNumber, String description, String expected){
	        logger.info("\n   Step_" + stepNumber + "\n   Description: " + description + "\n   Expected: " + expected);
	    }

}
