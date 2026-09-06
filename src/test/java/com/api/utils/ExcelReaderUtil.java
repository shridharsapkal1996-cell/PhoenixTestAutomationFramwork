package com.api.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtil {

	public static void main(String[] args) throws IOException {
		// APACHE POI OOXML LIB

		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("testData/PhoenixTestData.xlsx");
		XSSFWorkbook myWorkBook = new XSSFWorkbook(is);
		// Focus on the sheet

		XSSFSheet mySheet = myWorkBook.getSheet("loginTestData");
		XSSFRow myRow ;
		XSSFCell myCell ;

		
		
		//This condition for the last index whatever 
		int lastRowIndex=mySheet.getLastRowNum();
		System.out.println(lastRowIndex);          
		
		
		//this condition for the last index of col 
		XSSFRow rowHeader=mySheet.getRow(0);
		int lastIndexOfCol=rowHeader.getLastCellNum()-1; //Return the total number of cols
		System.out.println(lastIndexOfCol);
		
		
		for(int rowIndex=0; rowIndex<=lastRowIndex; rowIndex++) {
			for(int colIndex=0; colIndex<=lastIndexOfCol; colIndex++) {
				myRow=mySheet.getRow(rowIndex);
				myCell=myRow.getCell(colIndex);
				
				System.out.print(myCell+" ");
			}
			System.out.println("");
		}
		 

	}

}
