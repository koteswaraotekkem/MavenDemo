package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.CRMTestBase;
import com.freecrm.util.HelperWaitUtils;

public class crmNavBar extends CRMTestBase{

	
	private By newHelpCenterLink = By.linkText("New Help Center");
	private By CalenderMenu = By.linkText("Calendar");
	
	public crmNavBar(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean isNewHelpCenterIsDisplayed(){
		return driver.findElement(newHelpCenterLink).isDisplayed();
	}
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public void cickOnCalanderMenu(){
		HelperWaitUtils.sleepInSeconds(9);
		driver.findElement(CalenderMenu).click();
		
	}
	
	
}
