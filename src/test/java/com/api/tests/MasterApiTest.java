package com.api.tests;

import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class MasterApiTest {
	
	
	@Test(description="Verifying if the master api is giving correct response",groups= {"api","smoke","regression"})
	public void masterAPITest() {
		
		
	
		given()
		.spec(SpecUtils.requestSpecWithAuth(FD))
		 
		 .when()
		 .post("master")    //Default content-type
		 
		 .then()
		 .spec(SpecUtils.reponseSpec_ok())
		 .body("message", equalTo("Success"))
		 .body("data", notNullValue())
		 .body("data",hasKey("mst_oem"))
		 .body("data",hasKey("mst_model"))
		.body("$",hasKey("message"))  //$ means bigger outer message  
		.body("$",hasKey("data"))
		.body("data.mst_oem.size()", equalTo(2))  //Check the size of the JSON Array with Matchers 
		.body("data.mst_model.size()", greaterThan(0))
		.body("data.mst_oem.id", everyItem(notNullValue()))
		.body("data.mst_oem.name", everyItem(notNullValue()))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/MasterAPITestSchema.json"));

		
	}



//Negative test 
	
	@Test(description="Verifying if the master api is giving correct status ccode for inalid token",groups= {"api","negative","regression"})

	
public void invalidTokenmasterAPITest() {
		
		
		
	given()
	 .spec(SpecUtils.requestSpec())
	 .log().all()
	 
	 .when()
	 .post("master")    //Default content-type
	 
	 .then()
	 .log().all()
	 .spec(SpecUtils.reponseSpec_TEXT(0401));
		 
}
}
