package com.igbc.account;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import client.core.DesktopElementFactory;

public class CeateAccountTest extends DesktopElementFactory {
	WebDriver driver;

	
	@BeforeClass
	public void beforeClass(){
		int a=31110;
		Integer aa = new Integer(344);
		
		//Assert.assertFalse(true);
		
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://igbc.in/igbc");
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("====================================");
		System.out.println(method.getName());
		System.out.println("====================================");
		
		
		/*driver.findElement(By.xpath("//*[@id='boxes']/div[2]/div/form/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id='login']/div[4]/input[2]"))
				.click();
		;*/

	}

	@Test(description="Create account with normal account access", enabled=true, priority=1, groups="sanity")
	public void creteUserAccountTest() {
		System.out.println("***********************");
		Assert.assertTrue(true, "expecting true");
	}
	
	@Test(description="Sign in Functionality verification", priority=2, dependsOnMethods="creteUserAccountTest")
	public void signInTest() {
		System.out.println("SignIn");
	}
	
	@Test
	public void feedBackTest(){
		if (driver!=null) {
			driver.findElement(By.xpath("//a[text()='Feedback']")).click();	
		}
		
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass(){
		driver.quit();
	}
}
