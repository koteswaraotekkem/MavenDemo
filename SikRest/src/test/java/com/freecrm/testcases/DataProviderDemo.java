package com.freecrm.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	public  WebDriver driver;
	@BeforeClass
	public void befrClss(){
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\selenium\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
	@Test(dataProvider="userCredentials")
	public void testDatapRovider(String uname , String pwd) throws IOException, InterruptedException{
		//DeviceAccessOperations.killProcess("chromedriver");
		
		
		driver.get("https://www.igbc.in/igbc");
		driver.findElement(By.linkText("Sign In")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.name("emailId")).clear();
		driver.findElement(By.name("emailId")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(uname);
	}
	
	@DataProvider
	public Object[][] userCredentials(){
		
		Object[][] data = new Object[3][2];
		
		
		data[0][0] ="user1";
		data[0][1] ="userpppass";
		
		data[1][0] ="user2";
		data[1][1] ="userpppass";
		
		data[2][0] ="user3";
		data[2][1] ="userpppass";
		
		return data;
		
	}

}
