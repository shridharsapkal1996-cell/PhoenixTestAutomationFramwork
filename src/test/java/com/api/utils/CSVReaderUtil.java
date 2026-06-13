package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataprovider.api.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class CSVReaderUtil {

	/*
	 * 
	 * Constructor is private
	 *
	 * static static methods job Help me read the CSV file and Map it a Bean
	 *
	 *
	 */

	private CSVReaderUtil() {
		// No one can create Object of CSVReaderUtil OutSide the class
		// Singlton classs constructor are private

	}

	public static Iterator<UserBean> LoadCSV(String pathOfCSVFile) throws IOException, CsvException {
		// Code to read the CSV file in java !!! [Important interview questions]

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCreds.csv");
		InputStreamReader isr = new InputStreamReader(is);

		CSVReader csvReader = new CSVReader(isr); // CSVReader Constructor //Require a reader !!

	
		CsvToBean<UserBean> csvToBean = new CsvToBeanBuilder(csvReader)
				.withType(UserBean.class)
				.withIgnoreEmptyLine(true)
				.build();

		List<UserBean> userList = csvToBean.parse(); 
		return userList.iterator();
		

	}

	

}
