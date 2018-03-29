package controller;

import aipos.model.Author;
import aipos.model.Chapter;
import aipos.model.Item;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public List<Item> read() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        MyHandler myHandler = new MyHandler();
        reader.setContentHandler(myHandler);
        String currentDirectory = System.getProperty("user.dir");
        currentDirectory += "\\thriftServer\\temp.xml";
        reader.parse(currentDirectory);
        return myHandler.getItems();
    }
}
