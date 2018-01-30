package com.filereader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

/**
 * Created by sbasker on 3/26/17.
 */
public interface FileAdapter {
    public ArrayList<String[]> reader(String audioType, String fileName) throws IOException, ParseException, ParserConfigurationException, SAXException;
} // FileAdapter