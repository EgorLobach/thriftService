import controller.ClientController;
import org.apache.thrift.TException;
import thrift.ThriftClient;
import view.MainFrame;

public class Client {
    public static void main(String[] args) {
        ThriftClient thriftClient = new ThriftClient();
        ClientController clientController = new ClientController(thriftClient);
        try {
            new MainFrame(clientController);
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
