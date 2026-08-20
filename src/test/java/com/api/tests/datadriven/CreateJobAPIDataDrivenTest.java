package com.api.tests.datadriven;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.CreateJobPayload;
import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPIDataDrivenTest {

    @Test(
        description = "Verifying if create job api is able to create Inwarrenty job",
        groups = {"api", "smoke", "regression"},
        dataProviderClass = com.dataprovider.DataProviderUtils.class,
        dataProvider = "CreateJobAPIDataProvider"
    )
    
    public void createJobAPITest(CreateJobPayload payload) {
        given()
            .spec(SpecUtils.requestSpecWithAuth(Role.FD, payload))
        .when()
            .post("/job/create")
        .then()
            .spec(SpecUtils.reponseSpec_ok())
            .body("message", equalTo("Success"))
            .body("data.token", notNullValue())
            .assertThat()
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
                "responseSchema/createJobResponseSchema.json"
            ));
    }
}
