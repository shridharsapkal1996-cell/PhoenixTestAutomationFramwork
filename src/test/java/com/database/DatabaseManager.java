package com.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.api.utils.ConfigManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseManager {

	private static final String DB_URL = ConfigManager.getProperty("DB_URL");
	private static final String DB_USERNAME = ConfigManager.getProperty("DB_USER_NAME");
	private static final String DB_PASSWORD = ConfigManager.getProperty("DB_PASSWORD");
	private static final int MAX_POOL_SIZE = Integer.parseInt(ConfigManager.getProperty("MAXIMUM_POOL_SIZE"));
	private static final int MAXIMUM_IDLE_COUNT = Integer.parseInt(ConfigManager.getProperty("MINIMUM_IDLE_COUNT"));

	private static final int CONNECTION_TIMEOUT_IN_SECS = Integer
			.parseInt(ConfigManager.getProperty("CONNECTION_TIMEOUT_IN_SECS"));
	private static final int IDLE_TIMEOUT_SECS = Integer.parseInt(ConfigManager.getProperty("IDLE_TIMEOUT_SECS"));
	private static final int MAX_LIFE_TIME_IN_MINS = Integer
			.parseInt(ConfigManager.getProperty("MAX_LIFE_TIME_IN_MINS"));
	private static final int HIKARI_CP_POOL_NAME = Integer.parseInt(ConfigManager.getProperty("HIKARI_CP_POOL_NAME"));

	private static HikariConfig hikariConfig;
	private volatile static HikariConfig hikariDataSource;

	private static Connection conn;

	private DatabaseManager() {

	}

	public static void createConnection() throws SQLException {

		if (hikariDataSource == null) { // First check with all the parallel threads will enter
			synchronized (DatabaseManager.class) {

				hikariConfig.setJdbcUrl(ConfigManager.getProperty("DB_URL"));
				hikariConfig.setUsername(ConfigManager.getProperty("DB_USER_NAME"));
				hikariConfig.setPassword(ConfigManager.getProperty("DB_PASSWORD"));
				hikariConfig.setPassword(ConfigManager.getProperty("MAXIMUM_POOL_SIZE"));
				hikariConfig.setPassword(ConfigManager.getProperty("MINIMUM_IDLE_COUNT"));
				hikariConfig.setPassword(ConfigManager.getProperty("CONNECTION_TIMEOUT_IN_SECS"));
				hikariConfig.setPassword(ConfigManager.getProperty("IDLE_TIMEOUT_SECS"));
				hikariConfig.setPassword(ConfigManager.getProperty("MAX_LIFE_TIME_IN_MINS"));
				hikariConfig.setPassword(ConfigManager.getProperty("HIKARI_CP_POOL_NAME"));

				hikariConfig.setMaximumPoolSize(10);
				hikariConfig.setMinimumIdle(2);
				hikariConfig.setConnectionTimeout(10000); // 10 sec
				hikariConfig.setIdleTimeout(10000);
				hikariConfig.setMaxLifetime(1800000); // 30 Mins 30*60*1000
				hikariConfig.setPoolName("Phoenix test automation framwork pool");
				hikariDataSource = new HikariDataSource(hikariConfig);

			}
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = null;

		if (hikariDataSource == null) {
			initializePool(); // Step 2: Initialize HikariCP pool
		}

		try {
			// Step 3: Get a connection from the pool
			connection = ((HikariDataSource) hikariDataSource).getConnection();
		} catch (SQLException e) {
			e.printStackTrace(); // Step 4: Handle DB connection errors
		}

		// Step 5: Return the connection (could be null if exception occurred)
		return connection;
	}

	private static void initializePool() {
		// TODO Auto-generated method stub

	}


}