package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    
import com.api.request.model.UserCredentials;
import com.dataprovider.api.bean.UserBean;
import com.poiji.bind.Poiji;

public class ExcelReaderUtil2 {
    
    private ExcelReaderUtil2() {
    }

    public static Iterator<UserBean> loadTestData(String sheetName, Class<UserBean> clazz) throws IOException {
        // APACHE POI OOXML LIB
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("testData/PhoenixTestData.xlsx");

        // Always close workbook later
        XSSFWorkbook myWorkBook = new XSSFWorkbook(is);

        // Focus on the sheet
        XSSFSheet mySheet = myWorkBook.getSheet("loginTestData");
        
        
        List<UserBean> dataList= Poiji.fromExcel(mySheet, UserBean.class);
		return dataList.iterator();
        
        

        
       
      
    }
}
