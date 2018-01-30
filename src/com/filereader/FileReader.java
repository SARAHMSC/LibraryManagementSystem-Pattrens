package com.filereader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

/**
 * Created by sbasker on 3/26/17.
 */
public class FileReader implements FileAdapter {

	public ArrayList<String[]> reader(String fileType, String fileName)
			throws IOException, ParseException, ParserConfigurationException,
			SAXException {
		ArrayList<String[]>  lines = null;
		if (fileType.equalsIgnoreCase("csv")) {

			System.out.println("Reading csv File. Name: " + fileName);
			CSVFileArrayProvider fap = new CSVFileArrayProvider();
			lines = fap.readLines(fileName);

		} else if (fileType.equalsIgnoreCase("json")) {
			System.out.println("Reading json file. Name: " + fileName);

			JsonFileArrayProvider fap = new JsonFileArrayProvider();
			lines = fap.readLines(fileName);

		} else if (fileType.equalsIgnoreCase("xml")) {
			System.out.println("Reading xml file. Name: " + fileName);
			XmlFileArrayProvider fap = new XmlFileArrayProvider();
			lines = fap.readLines(fileName);

		} else {
			System.out.println("Invalid media. " + fileType
					+ " format not supported");
		}
		return lines;
	} // reader
} // FileReader