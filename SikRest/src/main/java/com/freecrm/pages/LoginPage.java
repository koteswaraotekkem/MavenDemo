package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.CrmTestBase;

public class LoginPage  extends CrmTestBase{

	@FindBy(name="username") 
	private  WebElement userName;
	@FindBy(name="password")  WebElement password;
	@FindBy(xpath="//input[@value='Login']")  WebElement LoginButton;
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
		userName.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		//waitForElementToBeClickable(LoginButton);
		if(LoginButton.isDisplayed()&& LoginButton.isEnabled())
		LoginButton.click();
		return new HomePage();
	}
	
	public void login(String uname, String  pwd){
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		//waitForElementToBeClickable(LoginButton);
		//if(LoginButton.isDisplayed()&& LoginButton.isEnabled())
		//LoginButton.click();
		//return new HomePage();
	}
}
