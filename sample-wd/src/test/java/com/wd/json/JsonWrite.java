package com.wd.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonWrite {
	public static void main(String[] args) {

		JSONObject obj = new JSONObject();

		// JSONObject class creates a json object,
		// provides a put function to insert the details into json object
		obj.put("name", "Abhishek Sharma");
		obj.put("department", "B.E");
		obj.put("branch", "C.S.E");
		obj.put("year", 3);

		JSONArray list = new JSONArray();

		// This is a JSON Array List ,
		// It creates an array and then add the values in it
		list.put("remark 1");
		list.put("remark 2");
		list.put("remark 3");

		obj.put("remarks", list);// adding the list to our JSON Object

		try (FileWriter file = new FileWriter("../newfile.json")) {
			// File Writer creates a file in write mode at the given location
			file.write(obj.toString());

			// write function is use to write in file,
			// here we write the Json object in the file
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(obj);
		System.out.println(list);
		// to print our JSon object
	}
}
