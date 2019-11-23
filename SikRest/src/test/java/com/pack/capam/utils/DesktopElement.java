package com.pack.capam.utils;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

public class DesktopElement {
String post = "/api/users";	
private String name="Kote swara rao Tekkem";
	@Test
	public void getReq(){
		System.out.println(name.substring(4));
		System.out.println(StringUtils.capitalize(post.split("/")[post.split("/").length -2]));
		
		
		Response resp = get("https://reqres.in/api/users?page=2");
		System.out.println(resp.asString());
	}
	
	@Test
	public void createNewRecord(){
		 RequestSpecification reqSpec = given();
		 reqSpec.header("Content-Type","application/json");
		 
	}
}
