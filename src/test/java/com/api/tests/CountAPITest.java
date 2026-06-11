package com.api.tests;

import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CountAPITest {

	@Test(description="Verifying if the count api is giving correct response",groups= {"api","smoke","regression"})
	public void verifyCountAPIResponse() {

		given()
		.spec(SpecUtils.requestSpecWithAuth(FD))

				.when().get("/dashboard/count")

				.then().log().all().statusCode(200).body("message", Matchers.equalTo("Success"))
				.time(Matchers.lessThan(2000L)).body("data", Matchers.notNullValue())

				.body("data.size()", Matchers.equalTo(3))
				.body("data.count", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
				.body("data.label", Matchers.everyItem(Matchers.not(Matchers.blankOrNullString())))
				.body("data.key",containsInAnyOrder("pending_for_delivery","created_today","pending_fst_assignment"))
				.body(JsonSchemaValidator
				.matchesJsonSchemaInClasspath("response-schema/CountAPIResponseSchema-FD.json"));
	}

	
	@Test(description="Verifying if the master api is giving correct status ccode for inalid token",groups= {"api","negative","regression"})


	public void countAPITest_MissingAuthToken() {
     //Negative test cases 
		given()
		.spec(SpecUtils.requestSpec())

				.when().get("/dashboard/count")

				.then().log().all()
				.spec(SpecUtils.reponseSpec_TEXT(401));
				
	}

}
