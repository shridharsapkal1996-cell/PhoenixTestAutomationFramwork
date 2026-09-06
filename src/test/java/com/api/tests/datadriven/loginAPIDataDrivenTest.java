package com.api.tests.datadriven;

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
import com.api.utils.SpecUtils;
import com.dataprovider.api.bean.UserBean;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class loginAPIDataDrivenTest {

	@Test(description = "Verify if the login api is worrking for user iamfd", groups = { "api", "regression",
			"datadriven" }, dataProviderClass = com.dataprovider.DataProviderUtils.class, dataProvider = "LoginAPIExcelDataProvider")

	public void loginAPITest(UserBean userbean) throws IOException {

		// Rest assured code

		// read the property va;lue that is to be going to be passed from terminal
		System.out.println("-------------->>>>" + System.getProperty("env"));

		// SetUp
		given().spec(SpecUtils.requestSpec(userbean))

				// Ation will be happen in when

				.when().post("login")

				// Validation will happen in Then
				.then().statusCode(200).time(lessThan(10000L)).and().body("message", equalTo("Success")).and()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));

		// Rest assured code

		// read the property va;lue that is to be going to be passed from terminal
		System.out.println("-------------->>>>" + System.getProperty("env"));

		UserCredentials userCredentials = new UserCredentials("iamfd", "password");

		// SetUp
		given().spec(SpecUtils.requestSpec(userCredentials))

				// Ation will be happen in when
				.when().post("login")

				// Validation will happen in Then
				.then().spec(SpecUtils.reponseSpec_ok()).time(lessThan(10000L)).and()
				.body("message", equalTo("Success")).and()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));

	}

}
