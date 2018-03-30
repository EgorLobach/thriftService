package xml;

import aipos.model.Author;
import aipos.model.Chapter;
import aipos.model.Item;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class FileHandler extends DefaultHandler {
    static final String DIRECTORY = "directory";
    static final String ITEM = "item";
    static final String ITEM_NAME = "itemName";
    static final String YEAR_OF_PUBLICATION = "yearOfPublication";
    static final String AUTHOR = "author";
    static final String FIRST_NAME = "firstName";
    static final String SECOND_NAME = "secondName";
    static final String CHAPTERS = "chapters";
    static final String CHAPTER = "chapter";
    static final String CHAPTER_NAME = "chapterName";
    static final String TEXT = "text";

    private List<Item> items;

    private Item item;
    private Author author;
    private Chapter chapter;
    private String currentElement;
    private List<Chapter> chapters;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        switch (currentElement){
            case DIRECTORY:{
                items = new ArrayList<>();
            } break;
            case ITEM:{
                item = new Item();
            } break;
            case AUTHOR:{
                author = new Author();
            } break;
            case CHAPTERS:{
                chapters = new ArrayList<>();
            } break;
            case CHAPTER:{
                chapter = new Chapter();
            } break;
            default: break;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case ITEM:{
                items.add(item);
                item = null;
            } break;
            case AUTHOR:{
                item.setAuthor(author);
                author = null;
            } break;
            case CHAPTERS:{
                item.setChapters(chapters);
                chapters = null;
            } break;
            case CHAPTER:{
                chapters.add(chapter);
                chapter = null;
            } break;
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        if (text.contains("<")||currentElement==null)
            return;
        switch (currentElement){
            case ITEM_NAME: item.setName(text); break;
            case YEAR_OF_PUBLICATION: item.setYearOfPublication(Long.parseLong(text)); break;
            case FIRST_NAME: author.setFirstName(text); break;
            case SECOND_NAME: author.setSecondName(text); break;
            case CHAPTER_NAME: chapter.setName(text); break;
            case TEXT: chapter.setText(text); break;
            default: break;
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start XML parsing...");
    }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("End XML parsing...");
    }

    public List<Item> getItems() {
        return items;
    }
}
