package com.freecrm.util;

import java.io.IOException;
import java.io.OutputStream;

import org.sikuli.basics.Settings;

public class DeviceAccessOperations {
	
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
	
	public static String getOSType(){
		System.out.println("OS Is : :"+Settings.getShortOS());
		return Settings.getShortOS();
	}

}
