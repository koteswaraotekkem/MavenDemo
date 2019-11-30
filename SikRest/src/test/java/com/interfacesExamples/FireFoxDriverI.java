package com.interfacesExamples;

import java.io.IOException;

public class FireFoxDriverI implements WebDriverI{
	
	public static void main(String[] args) {
	}

	public void findElement() {
		// TODO Auto-generated method stub
		
	}

	public void get(String url) {
	System.out.println("ama get method");
	
	try {
		Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
