package com.api.utils;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import com.api.constant.Role;
import com.api.request.model.UserCredentials;

import io.restassured.http.ContentType;

public class AuthTokenProvider {
	

	private AuthTokenProvider(){
		
	}
	
	static UserCredentials userCred=new UserCredentials("iamfd","password");
	
	public static String getToken(Role role) {
		
		
		//I want to make the request for the login api and we want to extract the token and 
		// Print it on console
		
		
		UserCredentials	UserCredentials=null;
		if(role==Role.FD) {
			UserCredentials=new UserCredentials("iamfd","password");
			
		}
		
		else if(role==Role.SUP) {
			UserCredentials=new UserCredentials("iamfd","password");
			
		}
		else if(role==Role.ENG) {
			UserCredentials=new UserCredentials("iamfd","password");
			
		}

		else if(role==Role.QC) {
			UserCredentials=new UserCredentials("iamfd","password");
			
		}
	
		String token =given()
		.baseUri(ConfigManager.getProperty("BASE_URI"))
		.contentType(ContentType.JSON)
		.body(userCred)
		
		
		.when()
		.post("login")
	
		
		.then()
		.statusCode(200)
		.body("message", equalTo("Success"))
		.log().all()
		.extract()
		.body()
		.jsonPath()
		.getString("data.token");
		
		System.out.println("-------------------->");
		System.out.println(token);
		return token;
		
		
		
		}
		
	}
