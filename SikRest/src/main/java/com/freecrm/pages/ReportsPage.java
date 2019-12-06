package com.freecrm.pages;

import org.openqa.selenium.By;

import com.freecrm.base.CRMTestBase;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsPage extends CRMTestBase {
private By calRepo = By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/table/tbody/tr[1]/td");
	
	public void verifyCallReports(){
		String callReportsString = driver.findElement(calRepo).getText();
		System.out.println("value in cal repo " + callReportsString);
		
	}
	
	
}
