package com.freecrm.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.file.io.ops.SamplePOIRead;
import com.freecrm.base.CrmTestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.DeviceAccessOperations;

public class RegisterNewUserTest extends CrmTestBase {

	
	
	String filePath = "E:\\Data\\";
	String fileName = "ReadMe.txt";
	
	static String dataToWrite ="Write Some dataccccccccccccccccc";
	
	@BeforeClass
	public void bfrclss(){
		initDriver();
	}
	@Test
	public void readfromtextFile() throws Throwable{

		
		int a=33;
		int b =455;
		
		if(a==b){
			System.out.println();
		}
		
		
		if(a!=b){
			System.out.println();
		}
		
		if(a<b){
			System.out.println();
		}
		
		if(a>b){
			System.out.println();
		}
		writeToFile(filePath, fileName);
		
	String data = readDataFromTextFile(filePath, fileName);
	System.out.println(data);
		FileInputStream fis = new FileInputStream(filePath+fileName);
		
		fis.read();
		int i=0;
		while ((i=fis.read())!=-1) {
		System.out.println((char)i);
		}
		fis.close();
	}
	
	
	private static String readDataFromTextFile(String filePath, String filename) throws IOException{
			 return new String (Files.readAllBytes(Paths.get(filePath+filename)));
		
	}
	
	public static void writeToFile(String filePath, String fileName) throws IOException {
		
		byte[] bytearr = dataToWrite.getBytes();
		
		FileOutputStream fos = new FileOutputStream(filePath+fileName);
		System.out.print(bytearr.length);
		fos.write(bytearr);
		fos.close();
		
	}
	
	
	
	
	
	@Test(enabled=false)
	public void readFromxl() throws Exception{
		
		SamplePOIRead samplePOIRead = new SamplePOIRead();
		String insideArr[][]=samplePOIRead.ExcelPOiRead("Sheet1");
		System.out.println("row length:::"+insideArr.length);
		System.out.println("column length:::"+insideArr[0].length);
		
		for (int i = 1; i < insideArr.length; i++) {
			 if(insideArr[i][0].equalsIgnoreCase("END")){
				 System.out.println("Only string matches to END..Break here"+insideArr[i][0]);
				    break;
					}
		}

	}
	
	@Test(description="user creation")
	public void signUp() throws Exception{
		LoginPage loginPage = new LoginPage();
		String titile = loginPage.getLoginPageTitile();
		System.out.println(titile);
		HomePage homepage= loginPage.login();
		homepage.getHomePageTitle();
		
	}
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
	
	
	@Test(dataProvider="userCredentials")
	public void testDatapRovider(String uname , String pwd) throws IOException, InterruptedException{
		//DeviceAccessOperations.killProcess("chromedriver");
		
		driver.get("https://www.igbc.in/igbc");
		driver.findElement(By.linkText("Sign In")).click();
		
		Thread.sleep(7000);
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(uname);
		
		
		
	}
	@DataProvider
	public Object[][] userCredentials(){
		
		Object[][] data = new Object[3][2];
		
		
		data[0][0] ="user1";
		data[0][1] ="userpppass";
		
		data[1][0] ="user2";
		data[1][1] ="userpppass";
		
		data[2][0] ="user1";
		data[2][1] ="userpppass";
		
		return data;
		
	}

}
