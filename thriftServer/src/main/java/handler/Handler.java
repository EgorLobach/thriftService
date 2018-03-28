package handler;

import aipos.model.Author;
import aipos.model.Item;
import aipos.model.Chapter;
import aipos.service.ItemService;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class Handler implements ItemService.Iface{
    List<Item> items = new ArrayList<>();

    public Handler(){
        List<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter("Введение", "Pascal (Паскаль) - язык программирования общего назначения."));
        chapters.add(new Chapter("Часть 1", "Текст программы состоит из трех составных частей. Это заголовок, описания, операторы."));
        items.add(new Item("Pascal beginer", 2010, new Author("Egor", "Lobach"), chapters));

        chapters = new ArrayList<>();
        chapters.add(new Chapter("Введение", "Паска́ль (англ. Pascal) — один из наиболее известных языков программирования[5], используется для обучения программированию в старших классах и на первых курсах вузов, является базой для ряда других языков."));
        items.add(new Item("Pascal for all", 2014, new Author("Sasha", "Lobach"), chapters));
    }

    @Override
    public Item addItem(Item Item) throws TException {
        if (items.indexOf(Item)!=-1)
            return null;
        else items.add(Item);
        return Item;
    }

    @Override
    public Item getItem(String name) throws TException {
        for(Item i: items)
            if(i.getName().equals(name))
                return i;
        return null;
    }

    @Override
    public Item updateItem(Item Item) throws TException {
        for(Item i: items)
            if(i.getName().equals(Item.getName())){
                items.set(items.indexOf(i), Item);
                System.out.println(Item.name);
                return Item;
            }
         return null;
    }

    @Override
    public Item deleteItem(String name) throws TException {
        for(Item i: items)
            if(i.getName().equals(name)){
                items.remove(i);
                return i;
            }
        return null;
    }

    @Override
    public List<Item> getItems() throws TException {
        return items;
    }
}
