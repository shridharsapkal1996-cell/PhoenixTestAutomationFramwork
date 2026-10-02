package com.database.dao;

import com.database.model.CustomerAddressDBModel;

public class CustomerAddresDaoRunner {
	public static void main(String[] args) {

		CustomerAddressDBModel customerAddressDBModel = CustomerAddressDao.getCustomerAddressData(112331);
		System.out.println(customerAddressDBModel);

	}
}