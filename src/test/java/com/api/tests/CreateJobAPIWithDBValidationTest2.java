 package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.Assert;
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
import com.api.utils.SpecUtils;
import com.database.dao.CustomerDao;
import com.database.model.CustomerDBModel;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateJobAPIWithDBValidationTest2 {
	private CreateJobPayload createJobPayload;
	Customer customer ;
	@BeforeMethod(description = "Creating createjob api request payload")
	public void setup() {
		
		 customer = new Customer("Jatin", "Shharma", "9637465019", "", "shridharsapkal2025@gmail.com", "");

		CustomerAddress customerAddress = new CustomerAddress("303", "Vasant nagar", "Bangur nagar", "inorbitmall",
				"Mumbai", "413601", "India", "maharastra");

		CustomerProduct customerProduct = new CustomerProduct(DateTimeUtil.getTimeWithDaysAgo(10), "79850107740127",
				"79850107740127", "79850107740127", DateTimeUtil.getTimeWithDaysAgo(10), Product.NEXUS_2.getCode(),
				Model.NEXUS_2_BLUE.getCode());

		Problems problems = new Problems(Problem.SMARTPHONE_IS_RUNNING_SLOW.getCode(), "Phone is not working");
		Problems[] problemsArray = new Problems[] { problems };

		// ✅ assign to the class field, not a local variable
		createJobPayload = new CreateJobPayload(ServiceLocation.SERVICE_LOCATION_A.getCode(),
				Platform.FRONT_DESK.getCode(), Warrenty_Status.IN_WARRENTY.getCode(), OEM.GOOGLE.getCode(), customer,
				customerAddress, customerProduct, problemsArray);
	}

	@Test(description = "Verifying if create job api is able to create Inwarrenty job", groups = { "api", "smoke",
			"regression" })
	public void createJobAPITest() {
		int customerID = given().spec(SpecUtils.requestSpecWithAuth(Role.FD, createJobPayload)).when()
				.post("/job/create")
				.then().spec(SpecUtils.reponseSpec_ok())
				 .body("message", equalTo("Success"))
				.body("data.token", notNullValue()).assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/createJobResponseSchema.json"))
				.body("data_mst_service_location_id", equalTo(1)).body("data_job_number", startsWith("JOB_")).extract()
				.body().jsonPath().getInt("data.tr_customer_id");
		System.out.println("-------------------");
		System.out.println(customerID);
		
		CustomerDBModel customerDataFromDB = CustomerDao.getCustomerInfo(customerID);
		System.out.println(customerDataFromDB);
		
		Assert.assertEquals(createJobPayload .customer().first_name(),customerDataFromDB.getFirst_name());
		Assert.assertEquals(createJobPayload.customer().first_name(),customerDataFromDB.getLast_name());
		Assert.assertEquals(createJobPayload.customer().first_name(),customerDataFromDB.getMobile_number());
		Assert.assertEquals(createJobPayload.customer().first_name(),customerDataFromDB.getEmail_id());
		Assert.assertEquals(createJobPayload.customer().first_name(),customerDataFromDB.getEmail_id_alt());
		Assert.assertEquals(createJobPayload.customer().first_name(),customerDataFromDB.getMobile_number_alt());
		System.out.println("-----------------------------------");
		
		

	}

	private ResponseAwareMatcher<Response> startsWith(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
