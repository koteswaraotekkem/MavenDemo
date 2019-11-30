package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.CRMTestBase;
import com.freecrm.util.HelperWaitUtils;

public class LoginPage extends CRMTestBase{

	//@FindBy(name="username") public  By userNameFindBy;
	public By userName = By.name("username");
	public By password = By.name("password");
	//public By userName = By.name("username");
	public By LoginButton = By.xpath("//input[@value='Login']");
	@FindBy(xpath="//a[text()='Home']")  WebElement HomeLink;
	@FindBy(xpath="(//img[contains(@class,'img-resp')])[1]")  WebElement crmLogo;
	@FindBy(xpath="(//*[@id='message']/text())[3]") WebElement sessionLogOut;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitile(){
		return driver.getTitle();
	}
	
	public boolean isCRMLogoDisplayed(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(){
		HelperWaitUtils.waitForElementToBeClickable(driver, userName);
		/*HelperWaitUtils.waitForElementToBeClickable(driver, userName);
		HelperWaitUtils.clearAndSetText(driver, userName, prop.getProperty("username"));
		HelperWaitUtils.clearAndSetText(driver, password, prop.getProperty("password"));
		HelperWaitUtils.waitForIsClickable(driver, LoginButton);
		HelperWaitUtils.clickOnElement(driver, LoginButton);*/
		return new HomePage();
	}
	
	public void login(String uname, String  pwd){
	/*	userName.sendKeys(uname);
		password.sendKeys(pwd);*/
		//waitForElementToBeClickable(LoginButton);
		//if(LoginButton.isDisplayed()&& LoginButton.isEnabled())
		//LoginButton.click();
		//return new HomePage();
	}
}
