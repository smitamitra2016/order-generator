package com.menu.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Utility {
	
	@Value("${tables}")
	private String tablesAsString;
	
	public List<String> getTables() {
		return Arrays.asList(StringUtils.split(tablesAsString, ","));
	}


	public int generateRandom(int size) {
		Random random = new Random();
		int val= random.nextInt(size);
		return random.nextInt(size);
	}
}
