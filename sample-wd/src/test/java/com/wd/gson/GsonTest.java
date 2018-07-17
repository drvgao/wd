package com.wd.gson;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class GsonTest {
	GsonUtils jsonUtil = new GsonUtils();
	ReadFromJsonFile readFromJsonFile = new ReadFromJsonFile();
	Map<String, String> playerDetailsMap = new HashMap<>();

	@Test
	public void f() {
		// readFromJsonFile.getAllPlayerDetails();
		playerDetailsMap = readFromJsonFile.getPlayerDetails("2");
		System.out.println("fname "+playerDetailsMap.get("fname"));
	}
}
