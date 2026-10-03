package com.database.dao;

import com.database.model.JobHeadModel;
import com.github.fge.jsonschema.main.cli.Main;

public class JobHeadModelRunner {
	public static void main(String[] args) {
		JobHeadModel jobHeadModel = JobHeadDao.getDataFromJobHead(113444);
		System.out.println(jobHeadModel);
	}

}