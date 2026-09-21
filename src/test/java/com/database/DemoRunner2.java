package com.database;

import java.sql.SQLException;

public class DemoRunner2 {
	public static void main(String[] args) throws SQLException {
	DatabaseManager.getConnection();
	long startTime=System.currentTimeMillis();
	
	for(int i=1; i<=10000; i++) {
			DatabaseManager.getConnection();
			DatabaseManager.getConnection();
			DatabaseManager.getConnection();
			DatabaseManager.getConnection();
			DatabaseManager.getConnection();

		}
	long endTime=System.currentTimeMillis();
	System.out.println("Duration  "+(endTime-startTime)+ "Ms");
	
	}
}