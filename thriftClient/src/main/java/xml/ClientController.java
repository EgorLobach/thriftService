package xml;

import aipos.model.Item;
import org.apache.thrift.TException;
import thrift.ThriftClient;

import java.util.List;

public class ClientController{

    private ThriftClient thriftClient;

    public ClientController(ThriftClient thriftClient) {
        this.thriftClient = thriftClient;
        this.thriftClient.start();
    }

    public Item addItem(Item item){
        try {
            return thriftClient.getService().addItem(item);
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Item getItem(String name){
        try {
            return thriftClient.getService().getItem(name);
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void updateItem(Item item){
        try {
            thriftClient.getService().updateItem(item);
        } catch (TException e) {
            e.printStackTrace();
        }
    }


    public void deleteItem(String name){
        try {
            thriftClient.getService().deleteItem(name);
        } catch (TException e) {
            e.printStackTrace();
        }
    }


    public List<Item> getItems(){
        try {
            return thriftClient.getService().getItems();
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }
}
