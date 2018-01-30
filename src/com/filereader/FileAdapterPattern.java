package com.filereader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

/**
 * Created by sbasker on 3/26/17.
 */
public class FileAdapterPattern {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, ParseException, IOException {
        FileReader fr = new FileReader();
        //System.out.println(FileAdapterPattern.class.getResource("datafile.csv").getPath());
        fr.reader("csv", FileAdapterPattern.class.getResource("datafile.csv").getPath());
        //fr.reader("xml", FileAdapterPattern.class.getResource("datafile.xml").getPath());
        //fr.reader("json", FileAdapterPattern.class.getResource("datafile.json").getPath());
    } // main
} //  FileAdapterPattern