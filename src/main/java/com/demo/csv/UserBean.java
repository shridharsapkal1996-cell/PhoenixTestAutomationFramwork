package com.demo.csv;


import com.opencsv.bean.CsvBindByName;

public class UserBean {

	@CsvBindByName(column = "username")
	private String username;

	@CsvBindByName(column = "password")
	private String password;

	
	public UserBean() {
    }

	public UserBean(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password + "]";
	}
	
}
