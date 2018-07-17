package com.wd.gson;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class ReadFromJsonFile {
	final static String PLAYERS_FILE_PATH = "src/test/resources/testdata/player_details.json";

	/**
	 * real fake data for registration
	 * 
	 * @return
	 */
	public static void getAllPlayerDetails() {
		final Type playerListType = new TypeToken<List<PlayerEntity>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader;
		List<PlayerEntity> data = null;
		// Map<String, String> playerDetailsMap = new HashMap<>();
		try {
			// 1. read data from JSON file
			reader = new JsonReader(new FileReader(PLAYERS_FILE_PATH));
			data = gson.fromJson(reader, playerListType);
			// System.out.println(data.size());
			for (int i = 0; i < data.size(); i++) {
				System.out.println();
				System.out.println("sno: " + String.valueOf(data.get(i).getSno()));
				System.out.println("fname: " + data.get(i).getfName());
				System.out.println("lname: " + data.get(i).getlName());
				System.out.println("email: " + data.get(i).getEmail());
				System.out.println("town: " + data.get(i).getTown());
				System.out.println("state: " + data.get(i).getState());
				System.out.println("used: " + data.get(i).getUsed());

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * return json as map
	 * 
	 * @return
	 */
	public static Map<String, String> getPlayerDetails(String no) {
		final Type playerListType = new TypeToken<List<PlayerEntity>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader;
		List<PlayerEntity> data = null;
		Map<String, String> playerDetailsMap = new HashMap<>();
		try {
			// 1. read data from JSON file
			reader = new JsonReader(new FileReader(PLAYERS_FILE_PATH));
			data = gson.fromJson(reader, playerListType);
			// System.out.println(data.size());
			for (int i = 0; i < data.size(); i++) {
				if (String.valueOf(data.get(i).getSno()).equalsIgnoreCase(no)) {
					// System.out.println("email: " + data.get(i).getEmail());
					// System.out.println("sno# " + data.get(i).getSno() + " and
					// index is: " + i);
					playerDetailsMap.put("sno", String.valueOf(data.get(i).getSno()));
					playerDetailsMap.put("fname", data.get(i).getfName());
					playerDetailsMap.put("lname", data.get(i).getlName());
					playerDetailsMap.put("email", data.get(i).getEmail());
					playerDetailsMap.put("town", data.get(i).getTown());
					playerDetailsMap.put("state", data.get(i).getState());
					playerDetailsMap.put("used", data.get(i).getUsed());

					// 2. update JSON file from JSON Object
					/*
					 * FileWriter writer = new FileWriter(PLAYERS_FILE_PATH); gson.toJson(data,
					 * writer); writer.flush(); System.out.println("File Updated. at s.no# " +
					 * data.get(i).getSno());
					 */

					reader.close();
					// writer.close();
					return playerDetailsMap;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return playerDetailsMap;
	}

}
