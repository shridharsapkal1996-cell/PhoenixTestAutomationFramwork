package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.request.model.UserCredentials;

public class ExcelReaderUtil2 {
    
    private ExcelReaderUtil2() {
    }

    public static Iterator<UserCredentials> loadTestData() throws IOException {
        // APACHE POI OOXML LIB
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("testData/PhoenixTestData.xlsx");

        // Always close workbook later
        XSSFWorkbook myWorkBook = new XSSFWorkbook(is);

        // Focus on the sheet
        XSSFSheet mySheet = myWorkBook.getSheet("loginTestData");

        // Read the Excel File ----> Stored in the ArrayList<UserCredentials>
        // I want to know the indexes for the username and password in our sheet
        XSSFRow headerRow = mySheet.getRow(0); // Header row

        int userNameIndex = -1;
        int passwordIndex = -1;

        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().trim().equalsIgnoreCase("username")) {
                userNameIndex = cell.getColumnIndex();
            }
            if (cell.getStringCellValue().trim().equalsIgnoreCase("password")) {
                passwordIndex = cell.getColumnIndex();
            }
        }
        System.out.println(userNameIndex + " " + passwordIndex);

        int lastRowIndex = mySheet.getLastRowNum();
        UserCredentials userCredentials;
        ArrayList<UserCredentials> userList = new ArrayList<>();

        for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {
            XSSFRow rowData = mySheet.getRow(rowIndex);
            if (rowData != null) {
                userCredentials = new UserCredentials(
                        rowData.getCell(userNameIndex).toString(),
                        rowData.getCell(passwordIndex).toString());
                userList.add(userCredentials);
            }
        }

       
        return userList.iterator(); // ✅ fixed: call iterator() method
    }
}
