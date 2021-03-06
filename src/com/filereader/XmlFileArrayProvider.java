package com.filereader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFileArrayProvider {

	public ArrayList<String[]> readLines(String filename) throws IOException,
			ParserConfigurationException, org.xml.sax.SAXException {

		File fXmlFile = new File(filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		ArrayList<String[]> lines = new ArrayList<String[]>();
		String data = "";

		// optional, but recommended
		// read this -
		// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("list");
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				if (nNode.hasChildNodes()) {
					NodeList cNodes = (NodeList) nNode.getChildNodes();
					for (int i = 0; i < cNodes.getLength(); i++) {
						data = cNodes.item(i).getTextContent();
						ArrayList<String> line = new ArrayList<String>();
						if (!data.equals("\n\n")) {
							int r = 0;
							for (String dataObj : data.split("\n")) {
								if (r > 0) {
									//System.out.println(dataObj.toString());
									line.add(dataObj);
								} // if
								r = r + 1;
							} // for
							lines.add(line.toArray(new String[line.size()]));
						} // if
						// System.out.println(cNodes.item(i).getTextContent());
					} // for
				} // if
			} // if
		} // for
	return lines;
	} // readLines
} // XmlFileArrayProvider