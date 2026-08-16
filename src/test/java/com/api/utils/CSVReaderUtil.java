package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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

	public static <T> Iterator<T> loadCSV(String pathOfCSVFile, Class<T> bean) {
		// Code to read the CSV file in java !!! [Important interview questions]

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader=new CSVReader(isr);
    
		

	
		CsvToBean<T> csvToBean = new CsvToBeanBuilder(csvReader)
				.withType(bean)
				.withIgnoreEmptyLine(true)
				.build();

		List<T> list = csvToBean.parse(); 
		return list.iterator();
		

	}

}


