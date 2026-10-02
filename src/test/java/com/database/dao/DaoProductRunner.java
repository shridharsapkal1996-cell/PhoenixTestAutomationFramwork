package com.database.dao;

import com.api.constant.Model;
import com.api.constant.Product;
import com.api.request.model.CustomerProduct;
import com.api.utils.DateTimeUtil;
import com.database.model.CustomerProductDBModel;

public class DaoProductRunner {
	public static void main(String[] args) {

		CustomerProductDBModel customerProductDBModel =CustomerProductDao.getProductInfoFromDB(113068);
		System.out.println(customerProductDBModel);
		CustomerProduct customerProduct = new CustomerProduct(DateTimeUtil.getTimeWithDaysAgo(10), "79850107740127",
				"79850107740127", "79850107740127", DateTimeUtil.getTimeWithDaysAgo(10), Product.NEXUS_2.getCode(),
				Model.NEXUS_2_BLUE.getCode());
		
		System.out.println(customerProduct);
		
		
	}
 
}
