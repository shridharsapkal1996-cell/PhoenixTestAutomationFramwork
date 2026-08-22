package com.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;

//Util Class
public class FakerDataGenerator {

	private static Faker faker = new Faker(new Locale("en-IND"));
	private final static String COUNTRY = "INDIA";
	private final static Random RANDOM = new Random();
	private final static int mst_service_location_id = 0;
	private final static int mst_platform_id = 2;
	private final static int mst_warrenty_status_id = 1;
	private final static int mst_oem_id = 1;
	private final static int PRODUCT_ID = 1;
	private final static int MODEL_ID = 1;

	private final static int validProblemsId[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 20,
			21, 22, 23, 24, 25, 26, 27, 28, 29 };

	private FakerDataGenerator() {

	}

	public static CreateJobPayload generateFakeCreateJobData() {

		Customer customer = generateFakeCustomerData();
		CustomerAddress customerAddress = generateFakeCustomerAddressData();
		CustomerProduct customerProduct = generateFakeCustomerProductData();
		List<Problems> problemsList = generateFakeProblemsList();

		// ✅ Fix: use the correct variable name and convert List to array
		CreateJobPayload payLoad = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct,
				problemsList.toArray(new Problems[0]));

		return payLoad;
	}

	public static Iterator<CreateJobPayload> generateFakeCreateJobData(int count) {

		List<CreateJobPayload> payloadList = new ArrayList<CreateJobPayload>();
		for (int i = 1; i <= count; i++) {
			Customer customer = generateFakeCustomerData();
			CustomerAddress customerAddress = generateFakeCustomerAddressData();
			CustomerProduct customerProduct = generateFakeCustomerProductData();
			List<Problems> problemsList = generateFakeProblemsList();

			// ✅ Fix: use the correct variable name and convert List to array
			CreateJobPayload payLoad = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct,
					problemsList.toArray(new Problems[0]));
		}
		return payloadList.iterator();
	}

	private static Customer generateFakeCustomerData() {

		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String mobileNumber = faker.numerify("70########");
		String alternateNumber = faker.numerify("70########");
		String CustomerEmailAddress = faker.internet().emailAddress();
		String altCustomerEmailAddress = faker.internet().emailAddress();

		Customer customer = new Customer(fname, lname, mobileNumber, alternateNumber, CustomerEmailAddress,
				altCustomerEmailAddress);
		System.out.println(customer);

		return customer;

	}

	private static CustomerAddress generateFakeCustomerAddressData() {

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

		return customerAddress;

	}

	private static CustomerProduct generateFakeCustomerProductData() {
		String dop = DateTimeUtil.getTimeWithDaysAgo(10);
		String imei1 = faker.numerify("###########");
		String popurl = faker.internet().url();
		CustomerProduct customerProduct = new CustomerProduct(dop, imei1, imei1, imei1, popurl, PRODUCT_ID, 1);
		System.out.println(customerProduct);

		return customerProduct;

	}

	private static List<Problems> generateFakeProblemsList() {
		int count = RANDOM.nextInt(3) + 1;
		int randomIndex;
		String fakeRemark;
		Problems problems;
		List<Problems> problemList = new ArrayList<Problems>();
		for (int i = 1; i <= count; i++) {
			// Random random = new Random();
			randomIndex = RANDOM.nextInt(validProblemsId.length);
			fakeRemark = faker.lorem().sentence(5);

			problems = new Problems(validProblemsId[randomIndex], fakeRemark);

			problemList.add(problems);
		}
		return problemList;
	}

	private final static String CCOUNTRY = "India";

	public static void generateFakeJobData() {

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
		CustomerProduct customerProduct = new CustomerProduct(dop, imei1, imei1, imei1, popurl, PRODUCT_ID, MODEL_ID);
		System.out.println(customerProduct);

		// I want to generate a random number between 1 to 27
		Random random = new Random();
		int problemId = random.nextInt(27) + 1;
		String fakeRemark = faker.lorem().sentence(10);

		Problems problems = new Problems(problemId, fakeRemark);
		System.out.println(problems);

		List<Problems> problemList = new ArrayList<Problems>();
		problemList.add(problems);

		CreateJobPayload payLoad = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct,
				problemList.toArray(new Problems[0]));

		System.out.println(payLoad);
	}

}
