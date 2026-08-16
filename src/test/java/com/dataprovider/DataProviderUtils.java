package com.dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.request.model.CreateJobPayload;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobBeanMapper;
import com.dataprovider.api.bean.CreateJobBean;
import com.dataprovider.api.bean.UserBean;
import com.opencsv.exceptions.CsvException;

public class DataProviderUtils {

	@DataProvider(name="CreateJobAPIDataProvider",parallel=true)
	public static Iterator<UserBean> loginAPIDataProvider() throws IOException, CsvException {
		return CSVReaderUtil.loadCSV("testData/LoginCreds.csv",UserBean.class);
	
		
	}

	// Data provider needs to return somthing
	// []
	// [] []
	// Iterator<>

	@DataProvider(name="CreateJobAPIDataProvider",parallel=true)
	public static Iterator<CreateJobPayload> createJobDataProvider() {
		
		Iterator<CreateJobBean> createJobBeanIterator=CSVReaderUtil.loadCSV("testData/CreateJobData.csv",CreateJobBean.class);
		
		
		List<CreateJobPayload> payloadlist=new ArrayList<CreateJobPayload>();
		CreateJobBean tempBean;
		CreateJobPayload tempPayload;
		
            while(createJobBeanIterator.hasNext()) {
			tempBean=createJobBeanIterator.next();
			tempPayload=CreateJobBeanMapper.mapper(tempBean);
		     payloadlist.add(tempPayload);
	
}
             return payloadlist.iterator();
}
}