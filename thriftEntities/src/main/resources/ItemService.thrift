namespace java aipos.service

include "Item.thrift"

service ItemService{
    Item.Item addItem(1: Item.Item item);

    Item.Item getItem(1: string name);

    Item.Item updateItem(1: Item.Item item);

    Item.Item deleteItem(1: string name);

    list<Item.Item> getItems();

}



