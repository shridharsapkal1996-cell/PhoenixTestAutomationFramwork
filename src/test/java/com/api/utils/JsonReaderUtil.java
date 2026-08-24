package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.api.request.model.UserCredentials;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReaderUtil {
	public static <T> Iterator<UserCredentials> loadJSON(String fileName, Class<UserCredentials[]> class1) {

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		ObjectMapper objectMapper = new ObjectMapper();

		UserCredentials[] classArray;

		List<UserCredentials> list = null;

		try {
			classArray = objectMapper.readValue(is, class1);
			list = Arrays.asList(classArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list.iterator();

	}
}
