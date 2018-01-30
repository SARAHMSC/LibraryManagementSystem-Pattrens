package com.filereader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class JsonFileArrayProvider {

	public ArrayList<String[]> readLines(String filename)
			throws FileNotFoundException, IOException, ParseException {

		ArrayList<String[]> lines = new ArrayList<String[]>();
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		JSONArray resources = (JSONArray) obj.get("resource");

		Iterator<JSONObject> data = resources.iterator();
		while (data.hasNext()) {
			JSONObject dataObj = data.next();
			Object[] arrVal = dataObj.keySet().toArray();
			Arrays.sort(arrVal);
			ArrayList<String> line = new ArrayList<String>();
			for (Object key : arrVal) {
				// based on you key types
				String keyStr = (String) key;
				String keyvalue = (String) dataObj.get(keyStr);
				line.add(keyvalue);
			} // for
			lines.add(line.toArray(new String[line.size()]));
		} // while
		return lines;
	} // readLines ()
} // JsonFileArrayProvider