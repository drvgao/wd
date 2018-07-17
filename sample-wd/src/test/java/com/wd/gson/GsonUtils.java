package com.wd.gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class GsonUtils {
	final static String PLAYERS_FILE_PATH = "src/test/resources/testdata/player_details.json";
	final static String EXISTING_PLAYERS_FILE_PATH = "src/test/resources/testdata/existing_player_details.json";

	/**
	 * real fake data for registration
	 * 
	 * @return
	 */
	public static Map<String, String> getPlayerDetails() {
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
				if (data.get(i).getUsed().equalsIgnoreCase("no")) {
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

					// 2. set the flag to yes in to JSON Object
					data.get(i).setUsed("yes");

					// 3. update JSON file from JSON Object
					FileWriter writer = new FileWriter(PLAYERS_FILE_PATH);
					gson.toJson(data, writer);
					writer.flush();
					System.out.println("File Updated. at s.no# " + data.get(i).getSno());

					reader.close();
					writer.close();
					return playerDetailsMap;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return playerDetailsMap;
	}

	
	public static void updateExistingPlayerDetailsJSON(String tcId, String email) {
		final Type existingPlayerListType = new TypeToken<List<ExistingPlayersEntity>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader;
		List<ExistingPlayersEntity> data = null;
		Map<String, String> existingPlayerDetailsMap = new HashMap<>();
		try {
			// 1. read data from JSON file
			reader = new JsonReader(new FileReader(EXISTING_PLAYERS_FILE_PATH));
			data = gson.fromJson(reader, existingPlayerListType);
			System.out.println(data.size());
			for (int i = 0; i < data.size(); i++) {
				if ((data.get(i).getTcid() == Integer.valueOf(tcId))
						&& (data.get(i).getFlag().equalsIgnoreCase("false"))) {
					System.out.println("email: " + data.get(i).getEmail());
					System.out.println("sno# " + data.get(i).getTcid() + " and index is: " + i);
					existingPlayerDetailsMap.put("tcid", String.valueOf(data.get(i).getTcid()));
					existingPlayerDetailsMap.put("username", data.get(i).getUsername());
					existingPlayerDetailsMap.put("pwd", data.get(i).getPwd());
					existingPlayerDetailsMap.put("email", email);
					existingPlayerDetailsMap.put("flag", "true");

					// 2. set the flag to yes in to JSON Object
					System.out.println("TCID: " + data.get(i).getTcid());

					// 3. update JSON file from JSON Object
					FileWriter writer = new FileWriter(EXISTING_PLAYERS_FILE_PATH);
					gson.toJson(data, writer);
					writer.flush();
					System.out.println("Existing players File Updated.");

					reader.close();
					writer.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
