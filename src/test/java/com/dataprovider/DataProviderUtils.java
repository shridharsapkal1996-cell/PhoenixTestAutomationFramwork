package com.dataprovider;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReaderUtil;
import com.dataprovider.api.bean.UserBean;
import com.opencsv.exceptions.CsvException;

public class DataProviderUtils {

	@DataProvider(name="LoginAPIDataProvider",parallel=true)
	public static Iterator<UserBean> loginAPIDataProvider() throws IOException, CsvException {
		return CSVReaderUtil.LoadCSV("testData/LoginCreds.csv");
	
		
	}
	//Data provider needs to return somthing 
	// []
	//[] []
	// Iterator<>
}
