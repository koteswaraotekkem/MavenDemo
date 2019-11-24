package com.freecrm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class  CrmTestBase {

	public static WebDriver driver;
	public static Properties prop;
	static String userWorkingDir = System.getProperty("user.dir");
	
	static{
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


	
	public void initDriver() {
		if (prop.getProperty("browser") != "chrome") {
			System.setProperty("webdriver.chrome.driver", userWorkingDir+"\\externalFiles\\drivers\\chromedriver98\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("destinationHost"));
	}
}
