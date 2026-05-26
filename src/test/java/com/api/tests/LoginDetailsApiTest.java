 package com.api.tests;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.api.constant.Role.*;

import com.api.constant.Role;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginDetailsApiTest {
	
	@Test
 public void LoginDetailsAPItest() throws IOException {
		
		
		
		Header authHeader = new Header("Authorization", AuthTokenProvider.getToken(Role.FD));

		
				
		  given()
	     .baseUri(ConfigManager.getProperty("BASE_URI"))
	     .and()
	     .header(authHeader)
	     .and()
	     .accept(ContentType.JSON) 
	     .log().uri()
	     .log().method()
	     .log().body()
	     .log().headers()

	      
	     .when()
	     .get("userdetails")
	     
	     .then()
	     .log().all()
	     .statusCode(200)
	     .time(lessThan(10000L))
	     .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/userdetails-schema.json"));
	    
	     
	     
		
	}

	

	
}
