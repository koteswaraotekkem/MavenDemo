package com.freecrm.config;

import com.freecrm.base.CRMTestBase;

public class CommonUtils extends CRMTestBase{

	public  void switchToFrame(){
		driver.switchTo().frame("mainpanel");
		System.out.println();
	}
	
}
