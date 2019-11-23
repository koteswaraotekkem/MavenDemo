package com.freecrm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  CrmTestBase {

	public static WebDriver driver;
	public static Properties prop;
	static String userWorkingDir = System.getProperty("user.dir");
	
	static{
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(userWorkingDir +"\\src\\main\\java\\com\\freecrm\\config\\"
					+ "\\configuration.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
public void waitForElementToBeClickable(WebElement xpath){
		
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable((xpath)));
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		}
	
	public void initDriver() {
		if (prop.getProperty("browser") != "chrome") {
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\selenium\\Drivers\\98\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("destinationHost"));
		//System.out.println(prop.getProperty("destinationHost"));
	}
}
