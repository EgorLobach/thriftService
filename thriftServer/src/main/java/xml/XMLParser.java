package xml;

import aipos.model.Chapter;
import aipos.model.Item;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import view.OpenFileDialog;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    private String currentDirectory;

    public XMLParser(){
        new OpenFileDialog(this);
    }

    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public List<Item> read(){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = saxParserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            FileHandler fileHandler = new FileHandler();
            reader.setContentHandler(fileHandler);
            reader.parse(currentDirectory);
            return fileHandler.getItems();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return  new ArrayList<Item>();
        }
    }

    public void write(List<Item> items){
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = null;
        try {
            writer = factory.createXMLStreamWriter(new FileOutputStream(currentDirectory));
            writer.writeStartDocument();
            writer.writeStartElement(FileHandler.DIRECTORY);
            for(Item item : items){
                writer.writeStartElement(FileHandler.ITEM);
                writer.writeStartElement(FileHandler.ITEM_NAME);
                writer.writeCharacters(item.getName());
                writer.writeEndElement();
                writer.writeStartElement(FileHandler.YEAR_OF_PUBLICATION);
                writer.writeCharacters(String.valueOf(item.getYearOfPublication()));
                writer.writeEndElement();
                writer.writeStartElement(FileHandler.AUTHOR);
                writer.writeStartElement(FileHandler.FIRST_NAME);
                writer.writeCharacters(item.getAuthor().getFirstName());
                writer.writeEndElement();
                writer.writeStartElement(FileHandler.SECOND_NAME);
                writer.writeCharacters(item.getAuthor().getSecondName());
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeStartElement(FileHandler.CHAPTERS);
                for(Chapter chapter : item.getChapters()){
                    writer.writeStartElement(FileHandler.CHAPTER);
                    writer.writeStartElement(FileHandler.CHAPTER_NAME);
                    writer.writeCharacters(chapter.getName());
                    writer.writeEndElement();
                    writer.writeStartElement(FileHandler.TEXT);
                    writer.writeCharacters(chapter.getText());
                    writer.writeEndElement();
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
