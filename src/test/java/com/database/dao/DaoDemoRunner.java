package com.database.dao;

import java.util.ArrayList;
import java.util.List;
import com.api.request.model.CreateJobPayload;
import com.api.utils.CreateJobBeanMapper;
import com.database.dao.CreateJobPayLoadDataDao.CreateJobPayloadDao.CreateJobPayloadDataDao;
import com.dataprovider.api.bean.CreateJobBean;

public class DaoDemoRunner {
	public static <CreateJobPayLoad> void main(String[] args) {
		List<CreateJobBean> beanList = CreateJobPayloadDataDao.getCreateJobPayLoadData();
		List<CreateJobPayload> payloadList = new ArrayList<CreateJobPayload>();
		for (CreateJobBean createJobBean : beanList) {
			CreateJobPayload payLoad = CreateJobBeanMapper.mapper(createJobBean);
			payloadList.add(payLoad);

		}
		System.out.println("--------------------------------------");
		for (CreateJobPayload payload : payloadList) {
			System.out.println(payload);
		}

	}

}
