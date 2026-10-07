package com.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.api.utils.ConfigManager;
import com.api.utils.EnvUtil;
import com.api.utils.VaultDBConflict;
import com.bettercloud.vault.VaultConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//This class should be merged in DatabaseManager class
public class DatabaseManagerForVault {

	HikariConfig hikariConfig = new HikariConfig();

	private static final String DB_URL = EnvUtil.getValue("DB_URL");
	private static final String DB_USERNAME = EnvUtil.getValue("DB_USERNAME");
	private static final String DB_PASSWORD = EnvUtil.getValue("DB_PASSWORD");
	private static final int MAXIMUM_POOL_SIZE = Integer.parseInt(ConfigManager.getProperty("MAXIMUM_POOL_SIZE"));
	private static final int    MINIMUM_IDLE_COUNT = Integer.parseInt(ConfigManager.getProperty("MINIMUM_IDLE_COUNT"));
	private static final int CONNECTION_TIMEOUT_IN_SECS = Integer
			.parseInt(ConfigManager.getProperty("CONNECTION_TIMEOUT_IN_SECS"));
	private static final int IDLE_TIMEOUT_SECS = Integer.parseInt(ConfigManager.getProperty("IDLE_TIMEOUT_SECS"));
	private static final int MAX_LIFE_TIME_IN_MINS = Integer
			.parseInt(ConfigManager.getProperty("MAX_LIFE_TIME_IN_MINS"));
	private static final String HIKARI_CP_POOL_NAME = ConfigManager.getProperty("HIKARI_CP_POOL_NAME");
	// private static final HikariConfig hikariConfig;
	private volatile static HikariDataSource hikariDataSource;

//	private static final String DB_URL=VaultConfig.getSecret("DB_URL");
//	private static final String DB_USERNAME=VaultConfig.getSecret("DB_USERNAME");
//	private static final String DB_PASSWORD=VaultConfig.getSecret("DB_PASSWORD");
//	

	public static String loadSecret(String key) {
		String value = null;

		value = VaultDBConflict.getSecret(key);
		if (value == null) {
			System.err.println("Vault is Down !! or some issue with vault");
		} else {
			System.out.println("Reading value from vault......");
			return value; // Coming from vault !!

		}
		// We need to pick up data from env !!
		System.out.println("READING VALUE FROM ENV......");
		value = EnvUtil.getValue(key);
		return value;

	}

}