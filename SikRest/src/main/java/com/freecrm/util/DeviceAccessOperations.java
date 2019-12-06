package com.freecrm.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class DeviceAccessOperations {
	public String reportsPath ="E:\\AutomationReport\\";
	public static void killProcess(String processName) throws IOException{
		
		Process process = null;
        String[] os_cmd = new String[]{"", "", ""};
        String command="";
        
		if (getOSType().contains("win")) {
			 os_cmd[0] = "cmd";
             os_cmd[1] = "/c";
			 if (!processName.endsWith("exe")) {
                 command=  "taskkill /f /im " + processName + ".exe" + " /t";
             } else {
            	 command= "taskkill /f /im " + processName;
             }
		}
		 os_cmd[2] = os_cmd[2] + command;
		 process = Runtime.getRuntime().exec(os_cmd);
	}
	
	public static String getOSType() {
		return System.getProperty("os.name").toLowerCase();
	}
	
public String captureScreenshot(WebDriver driver, String screenshotName) 
	
	{
		try{
			
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String dest = reportsPath+screenshotName+".jpeg";
		File destination = new File (dest);
		//FileUtils.copyFile(source, destination );
		
		return dest;
		}
		catch(Exception e){
			System.out.println("Exception while taking screenshot builder"+e.getMessage());
			return e.getMessage();
		}
	}

}
