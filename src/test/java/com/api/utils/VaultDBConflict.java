package com.api.utils;

import java.util.Map;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import com.bettercloud.vault.response.LogicalResponse;

public class VaultDBConflict {

	private static VaultConfig vaultConfig;
	private static Vault vault;

	static {
		try {
			vaultConfig = new VaultConfig().address("https://13.63.239.118:8200").token("root").build();

			vault = new Vault(vaultConfig);

		} catch (VaultException e) {
			e.printStackTrace();
		}
	}

	private VaultDBConflict() {
		// Prevent object creation
	}

	public static String getSecret(String key) {
		try {
			LogicalResponse response = vault.logical().read("secret/phoenix/qa/database");

			Map<String, String> dataMap = response.getData();

			return dataMap.get(key);

		} catch (VaultException e) {
			e.printStackTrace();
		}

		return null;
	}
}