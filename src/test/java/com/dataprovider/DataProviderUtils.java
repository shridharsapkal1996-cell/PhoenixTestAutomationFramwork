package com.dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.UserCredentials;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobBeanMapper;
import com.api.utils.ExcelReaderUtil2;
import com.api.utils.FakerDataGenerator;
import com.api.utils.JsonReaderUtil;
import com.dataprovider.api.bean.CreateJobBean;
import com.dataprovider.api.bean.UserBean;
import com.opencsv.exceptions.CsvException;

public class DataProviderUtils {

    // ✅ Login API DataProvider (reads CSV of user credentials)
    @DataProvider(name = "LoginAPIDataProvider", parallel = true)
    public static Iterator<UserBean> loginAPIDataProvider() throws IOException, CsvException {
        return CSVReaderUtil.loadCSV("testData/LoginCreds.csv", UserBean.class);
    }

    // ✅ Create Job API DataProvider (reads CSV and maps beans to payloads)
    @DataProvider(name = "CreateJobAPIDataProvider", parallel = true)
    public static Iterator<CreateJobPayload> createJobDataProvider() {
        Iterator<CreateJobBean> createJobBeanIterator =
                CSVReaderUtil.loadCSV("testData/CreateJobData.csv", CreateJobBean.class);

        List<CreateJobPayload> payloadList = new ArrayList<>();
        while (createJobBeanIterator.hasNext()) {
            CreateJobBean tempBean = createJobBeanIterator.next();
            CreateJobPayload tempPayload = CreateJobBeanMapper.mapper(tempBean);
            payloadList.add(tempPayload);
        }
        return payloadList.iterator();
    }

    // ✅ Faker-based Create Job DataProvider (generates fake payloads)
    @DataProvider(name = "CreateJobAPIFakerProvider", parallel = true)
    public static Iterator<CreateJobPayload> createJobFakeDataProvider() {
        String fakerCount = System.getProperty("fakerCount", "5");
        int fakerCountInt = Integer.parseInt(fakerCount);

        return FakerDataGenerator.generateFakeCreateJobData(fakerCountInt);
    }

    // ✅ Login API JSON DataProvider (reads JSON file into UserCredentials)
    @DataProvider(name = "LoginAPIJsonDataProvider", parallel = true)
    public static Iterator<UserCredentials> loginAPIJsonDataProvider() {
        return JsonReaderUtil.loadJSON("testData/demo.json", UserCredentials[].class);
    }
    
    
 // ✅ Login API JSON DataProvider (reads JSON file into UserCredentials)
    @DataProvider(name = "loginAPIExcelDataProvider", parallel = true)
    public static Iterator<UserCredentials> loginAPIJExelDataProvider() throws IOException {
        return ExcelReaderUtil2.loadTestData();
    }
}
