package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.UserCredentials;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class loginAPI {

	private UserCredentials userCredentials;

	@BeforeMethod(description = "create the Payload for the login API")
	public void setup() {
		UserCredentials userCredentials = new UserCredentials("iamfd", "password");

	}

	@Test(description = "Verify if the login api is worrking for user iamfd", groups = { "api", "regression", "smoke" })
	public void apiTest() throws IOException {

		Header authHeader = new Header("Authorization", AuthTokenProvider.getToken(Role.FD));
		// Rest assured code

		// read the property va;lue that is to be going to be passed from terminal
		System.out.println("-------------->>>>" + System.getProperty("env"));

		// SetUp
		given().baseUri(ConfigManager.getProperty("BASE_URI")).and().contentType(ContentType.JSON).and()
				.body(userCredentials).log().uri().log().method().log().headers().log().body()

				// Ation will be happen in when

				.when().post("login")

				// Validation will happen in Then
				.then()
				.statusCode(200).time(lessThan(10000L))
				.and()
				.body("message", equalTo("Success"))
				.and()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));

	}

}
