package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constant.Model;
import com.api.constant.OEM;
import com.api.constant.Platform;
import com.api.constant.Problem;
import com.api.constant.Product;
import com.api.constant.Role;
import com.api.constant.ServiceLocation;
import com.api.constant.Warrenty_Status;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.api.utils.DateTimeUtil;
import com.api.utils.FakerDataGenerator;
import com.api.utils.SpecUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITestWithFakeData {
    private CreateJobPayload createJobPayload;

    @BeforeMethod(description="Creating createjob api request payload")
    public void setup() {
    	
    	createJobPayload=FakerDataGenerator.generateFakeCreateJobData();
    }

    @Test(description="Verifying if create job api is able to create Inwarrenty job", groups={"api","smoke","regression"})
    public void createJobAPITest() {
        given()
            .spec(SpecUtils.requestSpecWithAuth(Role.FD, createJobPayload))
        .when()
            .post("/job/create")
        .then()
            .spec(SpecUtils.reponseSpec_ok())
            .body("message", equalTo("Success"))
            .body("data.token", notNullValue())
            .assertThat()
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/createJobResponseSchema.json"));
    }
}
