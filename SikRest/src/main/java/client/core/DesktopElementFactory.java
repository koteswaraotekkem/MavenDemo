package client.core;

import org.testng.annotations.BeforeSuite;

public class DesktopElementFactory {

	static{
		System.out.println("i amin static block");
	}
	
	static{
		System.out.println("i amin static2 block");
	}
	
	static{
		System.out.println("i amin static3 block");
	}
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("i am in before suite");
	}
	
	public void beforeclass(){
		System.out.println("rrr");
	}
	
	public void beforemethod(){
		
	}
	
	public DesktopElementFactory(){
		System.out.println("iam DesktopElementFactory class con");
	}
}
