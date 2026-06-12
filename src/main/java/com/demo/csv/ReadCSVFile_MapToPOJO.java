package com.demo.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile_MapToPOJO {

	public static void main(String[] args) throws IOException, CsvException {
		// Code to read the CSV file in java !!! [Important interview questions]

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCreds.csv");
		InputStreamReader isr = new InputStreamReader(is);


		CSVReader csvReader = new CSVReader(isr); // CSVReader Constructor //Require a reader !!
		
		//Write thge code to map CSV to POJO
		//Its convered csv to object 
		CsvToBean<UserBean> csvToBean=new CsvToBeanBuilder(csvReader)
				.withType(UserBean.class)
				.withIgnoreEmptyLine(true) 
				.build();  
		
		
		List<UserBean> userList=csvToBean.parse();
		System.out.println(userList);

			}

}
