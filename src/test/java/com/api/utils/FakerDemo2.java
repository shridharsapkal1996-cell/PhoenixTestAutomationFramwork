package com.api.utils;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.api.constant.Problem;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;

public class FakerDemo2 {
	private final static String CCOUNTRY = "India";

	public static void main(String[] args) {
		/// Create Fake CreatJobApi requestr Payload

		Faker faker = new Faker(new Locale("en-IND")); // Help me create India specific fake data
   
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String mobileNumber = faker.numerify("70########");
		String alternateNumber = faker.numerify("70########");
		String CustomerEmailAddress = faker.internet().emailAddress();
		String altCustomerEmailAddress = faker.internet().emailAddress();

		Customer customer = new Customer(fname, lname, mobileNumber, alternateNumber, CustomerEmailAddress,
				altCustomerEmailAddress);
		System.out.println(customer);

		String flatNumber = faker.numerify("###");
		String apartmentName = faker.address().streetName();
		String streetName = faker.address().streetName();
		String landMark = faker.address().streetName();
		String area = faker.address().streetName();
		String pincode = faker.numerify("#####");
		String country = faker.address().country();
		String State = faker.address().state();

		CustomerAddress customerAddress = new CustomerAddress(flatNumber, apartmentName, streetName, landMark, area,
				pincode, CCOUNTRY, State);
		System.out.println(customerAddress);

		// CustomerProduct Fake Object
		String dop = DateTimeUtil.getTimeWithDaysAgo(10);
		String imei1 = faker.numerify("###########");
		String popurl = faker.internet().url();
		CustomerProduct customerProduct = new CustomerProduct(dop, imei1, imei1, imei1, popurl, 1, 1);
		System.out.println(customerProduct);

		String fakeRemark = faker.lorem().sentence(10);

		// I want to generate a random number between 1 to 27
		Random random = new Random();
		int problemId = random.nextInt(27) + 1;
		Problems problems = new Problems(problemId, fakeRemark);
		
		System.out.println(problems);

		List<Problems> problemList = new ArrayList<Problems>();
		problemList.add(problems);

		CreateJobPayload payLoad = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct,
				problemList.toArray(new Problems[0]));

		System.out.println(payLoad);
	}
}
