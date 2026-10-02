package com.database.model;

public class CustomerProductDBModel {
	
	private int id;
	private int tr_customer_id;
	private int mst_model_id;
	private String dop;
	private String popurl;
	private String imei2;
	private String imei1;
	private String serial_number;
	public CustomerProductDBModel(int id, int tr_customer_id, int mst_model_id, String dop, String popurl, String imei2,
			String imei1, String serial_number) {
		super();
		this.id = id;
		this.tr_customer_id = tr_customer_id;
		this.mst_model_id = mst_model_id;
		this.dop = dop;
		this.popurl = popurl;
		this.imei2 = imei2;
		this.imei1 = imei1;
		this.serial_number = serial_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTr_customer_id() {
		return tr_customer_id;
	}
	public void setTr_customer_id(int tr_customer_id) {
		this.tr_customer_id = tr_customer_id;
	}
	public int getMst_model_id() {
		return mst_model_id;
	}
	public void setMst_model_id(int mst_model_id) {
		this.mst_model_id = mst_model_id;
	}
	public String getDop() {
		return dop;
	}
	public void setDop(String dop) {
		this.dop = dop;
	}
	public String getPopurl() {
		return popurl;
	}
	public void setPopurl(String popurl) {
		this.popurl = popurl;
	}
	public String getImei2() {
		return imei2;
	}
	public void setImei2(String imei2) {
		this.imei2 = imei2;
	}
	public String getImei1() {
		return imei1;
	}
	public void setImei1(String imei1) {
		this.imei1 = imei1;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	@Override
	public String toString() {
		return "CustomerProductDBModel [id=" + id + ", tr_customer_id=" + tr_customer_id + ", mst_model_id="
				+ mst_model_id + ", dop=" + dop + ", popurl=" + popurl + ", imei2=" + imei2 + ", imei1=" + imei1
				+ ", serial_number=" + serial_number + "]";
	}
	
	

}
