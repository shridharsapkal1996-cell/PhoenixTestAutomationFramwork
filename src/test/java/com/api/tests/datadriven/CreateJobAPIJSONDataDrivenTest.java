package com.api.tests.datadriven;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.UserCredentials;
import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;

public class CreateJobAPIJSONDataDrivenTest {

    @Test(
        description = "Verifying if login api is able to authenticate user",
        groups = {"api", "smoke", "regression"},
        dataProviderClass = com.dataprovider.DataProviderUtils.class,
        dataProvider = "LoginAPIDataProvider"   // ✅ corrected to match provider name
    )
    public void loginAPITest(UserCredentials userCredentials) {
        given()
            .spec(requestSpec(userCredentials))
        .when()
            .post("/login")   // ✅ corrected endpoint format
        .then()
            .spec(SpecUtils.reponseSpec_ok())
            .body("message", equalTo("Success"))
            .body("data.token", notNullValue())
            .assertThat()
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
                "responseSchema/loginResponseSchema.json"   // ✅ corrected schema file
            ));
    }

    private RequestSpecification requestSpec(UserCredentials userCredentials) {
        return SpecUtils.requestSpecWithAuth(Role.FD, userCredentials);
    }
}
 