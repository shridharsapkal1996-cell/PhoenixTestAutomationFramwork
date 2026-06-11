 package com.api.tests;
import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginDetailsApiTest {
	
	@Test(description="Verify if the UserDetails API response is shown correctly",groups= {"api","smoke","regression"})
 public void LoginDetailsAPItest() throws IOException {
		
		
		
	

		
				
		  given()
	      .spec(SpecUtils.requestSpecWithAuth(FD))

	        
	     .when()
	     .get("userdetails")
	     
	     .then()
	     .log().all()
	     .spec(SpecUtils.reponseSpec_ok())
	     .time(lessThan(10000L))
	     .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/userdetails-schema.json"));
	    
	     
	     
		
	}

	

	
}
