package client.core;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.freecrm.base.CRMTestBase;

public class PagebaseWaitUtils extends CRMTestBase {
	
	@BeforeClass
	public void waitForElelementToView(){
		System.out.println("waiting for this ele to dispaly");
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("before method in pagebae utils");
	}

}
