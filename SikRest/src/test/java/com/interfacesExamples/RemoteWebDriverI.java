package com.interfacesExamples;

import java.io.IOException;

public class RemoteWebDriverI  implements WebDriverI{

	@Override
	public void findElement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get(String url) {
		if (url=="chrome") {
			try {
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
if (url=="operA") {
			
		}

if (url=="ff") {
	
}
		
	}

}
