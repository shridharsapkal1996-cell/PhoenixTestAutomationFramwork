package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import com.api.utils.ConfigManagerOLD;
import com.api.utils.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class loginAPI {
	
	
	@Test
	public void apiTest() throws IOException {
		//Rest assured code
		
		//read the property va;lue that is to be going to be passed from terminal 
		System.out.println("-------------->>>>"+System.getProperty("env"));
		  
		UserCredentials userCredentials=new UserCredentials("iamfd","password");
		
	  
		 
		//SetUp
		given()
          .baseUri(ConfigManager.getProperty("BASE_URI"))
          .and()
          .contentType(ContentType.JSON)
          .and()
          .body(userCredentials)
          .log().uri()
          .log().method()
          .log().headers()
          .log().body()
          
          //Ation will be happen in when 
          
          .when()
            .post("login")
            
           
            //Validation will happen in Then
          .then()
            .statusCode(200)
            .time(lessThan(10000L))
            .and()
            .body("message",equalTo("Success"))
		    .and()
		    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));
		    
	}

}

