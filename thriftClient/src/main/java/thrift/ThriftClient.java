package thrift;

import aipos.service.ItemService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    private static final int PORT = 9090;
    private ItemService.Client service;
    private TTransport transport;
    public void start(){
        try {
            transport = new TSocket("localhost", PORT);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            service = new ItemService.Client(protocol);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        transport.close();
    }

    public ItemService.Client getService() {
        return service;
    }
}
