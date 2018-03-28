import controller.ClientController;
import thrift.ThriftClient;
import view.MainFrame;

public class Client {
    public static void main(String[] args) {
        ThriftClient thriftClient = new ThriftClient();
        ClientController clientController = new ClientController(thriftClient);
        new MainFrame(clientController);
    }
}
