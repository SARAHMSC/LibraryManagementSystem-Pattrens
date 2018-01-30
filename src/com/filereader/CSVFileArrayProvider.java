package com.filereader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sbasker on 3/22/17.
 */
public class CSVFileArrayProvider {
	public ArrayList<String[]> readLines(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String[]> lines = new ArrayList<String[]>();
		String line = null;
		String cvsSplitBy = ",";

		while ((line = bufferedReader.readLine()) != null) {
			String[] data = line.split(cvsSplitBy);
			lines.add(data);
		} // while
		bufferedReader.close();
		return lines;
	} // readLines()
} // CSVFileArrayProvider