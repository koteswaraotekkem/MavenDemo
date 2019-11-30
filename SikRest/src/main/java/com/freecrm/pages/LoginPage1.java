package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.freecrm.base.CRMTestBase;

public class LoginPage1 extends  CRMTestBase{
	@FindBy(name="username") public  By userNameFindBy;
	@FindBy(name="password") public  WebElement pwd;
private By userName = By.name("username");

private By password = By.name("password");
 private By loginBtn = By.xpath("//input[@value='Login']");
 
public  LoginPage1(){
	PageFactory.initElements(driver, this);
}
 
 
public HomePage loginAsSuperUser(){
	driver.findElement(userName).clear();
	driver.findElement(By.linkText("Home"));
	String str = driver.findElement(userName).getAttribute("placeholder");
	System.out.println(str);
	driver.findElement(userName).sendKeys(prop.getProperty("username"));
	
	driver.findElement(password).clear();
	driver.findElement(password).sendKeys(prop.getProperty("password"));
	try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(loginBtn).click();
	return new HomePage();
	
}
}
