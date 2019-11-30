package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.CRMTestBase;

public class HomePage extends CRMTestBase{
	
	private By newHelpCenterLink = By.linkText("New Help Center");
	private By CalenderMenu = By.xpath("//*[@id='navmenu']/ul/li[2]/a");
	private By Home = By.linkText("Home");
	private By reports = By.xpath("//*[@id='navmenu']/ul/li[15]/a");
	
	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[2]") public WebElement UserName;
	@FindBy(xpath="/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[2]/a") public WebElement setUP;
	
	
	/*public HomePage(){
		PageFactory.initElements(driver, this);
	}*/
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHomePageDetails(){
		WebElement repElement = driver.findElement(reports);
		System.out.println(repElement.isDisplayed());
		UserName.isDisplayed();
		setUP.click();
		 driver.findElement(reports).click();
		
	}
	
	public boolean isNewHelpCenterIsDisplayed(){
		return driver.findElement(newHelpCenterLink).isDisplayed();
	}
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public CalandarPage openCalanderPage(){
		//driver.findElement(Home).click();
		driver.findElement(CalenderMenu).click();
		System.out.println(19);
		return new CalandarPage();
		
	}
	
	public ReportsPage openReports(){
		driver.findElement(reports).click();
		
		return new ReportsPage();
		
	}
	
	
}
