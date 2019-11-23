package com.freecrm.testcases;

import io.restassured.RestAssured;

import org.testng.annotations.Test;

public class APiTestBase {



@Test
public void getCall(){
	
	int sCode=RestAssured.get("http://api.5min.com/").getStatusCode();
	System.out.println(sCode);
}
}

