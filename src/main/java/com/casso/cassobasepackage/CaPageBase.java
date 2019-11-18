package com.casso.cassobasepackage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaPageBase {
	public WebDriver driver;
	public static Properties props;
	public String currentDir = System.getProperty("user.dir");

	{

		props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(currentDir + "\\src\\configuration.properties");
			props.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
		intitDriver();

	}

	@Test
	public void createUser() {
		driver.get(props.getProperty("url"));
	}

	public void intitDriver() {
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

}
