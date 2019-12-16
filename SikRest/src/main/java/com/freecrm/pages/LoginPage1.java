package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freecrm.base.CRMTestBase;
import com.freecrm.util.HelperWaitUtils;

public class LoginPage1 extends  CRMTestBase{
	@FindBy(name="username") public  By userNameFindBy;
	@FindBy(name="password") public  WebElement pwd;
private By userName = By.name("username");

private By password = By.name("password");
 private By loginBtn = By.xpath("//input[@value='Login']");
 
 private By userNameInHomeage = By.xpath("//input[@value='vvvvvvvvvvvvvvvvvvvvvv']");
 
public  LoginPage1(){
	PageFactory.initElements(driver, this);
}
 
 
public HomePage loginAsSuperUser(){
	driver.findElement(userName).sendKeys(prop.getProperty("username"));
	driver.findElement(password).clear();
	driver.findElement(password).sendKeys(prop.getProperty("password"));
	HelperWaitUtils.waitForIsClickable(driver, loginBtn);
	driver.findElement(loginBtn).click();
	return new HomePage();
	
	}
public String getHomePageTititle(){
	return driver.getTitle();
}

public boolean isUserNameDispalyed(){
	
	return driver.findElement(userNameInHomeage).isDisplayed();
}
 
}
