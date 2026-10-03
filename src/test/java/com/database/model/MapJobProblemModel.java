package com.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public class MapJobProblemModel {
	
	private int id;
	private int tr_job_head_id;
	private int mst_problem_id;
	private  String remark;
	
	
	public MapJobProblemModel(int id, int tr_job_head_id, int mst_problem_id, String string) {
		super();
		this.id = id;
		this.tr_job_head_id = tr_job_head_id;
		this.mst_problem_id = mst_problem_id;
		this.remark = string;
	}
	
	
	
	

}
