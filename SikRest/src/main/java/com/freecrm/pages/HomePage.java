package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.CrmTestBase;

public class HomePage extends CrmTestBase{

	
	@FindBy(linkText="New Help Center") WebElement newHelpCenterLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean isNewHelpCenterIsDisplayed(){
		return newHelpCenterLink.isDisplayed();
	}
	public void getHomePageTitle(){
		driver.getTitle();
	}
	
	
	
}
