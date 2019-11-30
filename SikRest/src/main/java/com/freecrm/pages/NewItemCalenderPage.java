package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.freecrm.base.CRMTestBase;

public class NewItemCalenderPage extends CRMTestBase{

	
	@FindBy(linkText="New Event") WebElement newHelpCenterLink;
	
	public By NewItem = By.linkText("New Event");
	public NewItemCalenderPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public NewItemCalenderPage clickNewItem(){
		driver.findElement(NewItem).click();
		return new NewItemCalenderPage();
	}
	
	
	
}
