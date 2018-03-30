package handler;

import aipos.model.Author;
import aipos.model.Item;
import aipos.model.Chapter;
import aipos.service.ItemService;
import controller.XMLParser;
import org.apache.thrift.TException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Handler implements ItemService.Iface{
    private XMLParser parser;
    private List<Item> items;

    public Handler(){
        parser = new XMLParser();
        items = parser.read();

    }

    @Override
    public Item addItem(Item Item) throws TException{
        if (items.indexOf(Item)!=-1)
            return null;
        else items.add(Item);
        parser.write(items);
        return Item;
    }

    @Override
    public Item getItem(String name) throws TException{
        items = parser.read();
        for(Item i: items)
            if(i.getName().equals(name))
                return i;
        return null;
    }

    @Override
    public Item updateItem(Item Item) throws TException{
        for(Item i: items)
            if(i.getName().equals(Item.getName())){
                items.set(items.indexOf(i), Item);
                parser.write(items);
                return Item;
            }
         return null;
    }

    @Override
    public Item deleteItem(String name) throws TException{
        for(Item i: items)
            if(i.getName().equals(name)){
                items.remove(i);
                parser.write(items);
                return i;
            }
        return null;
    }

    @Override
    public List<Item> getItems() throws TException, IOException {
        return parser.read();
    }
}
