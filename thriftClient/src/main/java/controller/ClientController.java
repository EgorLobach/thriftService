package controller;

import aipos.model.Item;
import aipos.service.ItemService;
import org.apache.thrift.TException;
import thrift.ThriftClient;

import java.util.List;

public class ClientController implements ItemService.Iface{

    private ThriftClient thriftClient;

    public ClientController(ThriftClient thriftClient) {
        this.thriftClient = thriftClient;
        this.thriftClient.start();
    }

    @Override
    public Item addItem(Item item) throws TException {
        return thriftClient.getService().addItem(item);
    }

    @Override
    public Item getItem(String name) throws TException {
        return thriftClient.getService().getItem(name);
    }

    @Override
    public Item updateItem(Item item) throws TException {
        return thriftClient.getService().updateItem(item);
    }

    @Override
    public Item deleteItem(String name) throws TException {
        return thriftClient.getService().deleteItem(name);
    }

    @Override
    public List<Item> getItems() throws TException {
        return thriftClient.getService().getItems();
    }
}
