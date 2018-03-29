import aipos.service.ItemService;
import handler.Handler;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Server {
    private static final int PORT = 9090;

    public static void main(String args[]){
        Server server = new Server();
        server.start();
    }

    private void start(){
        try {
            TServerSocket serverTransport = new TServerSocket(PORT);
            Handler handler = new Handler();
            ItemService.Processor<ItemService.Iface> processor
                    = new ItemService.Processor<>(handler);

            TServer server = new TThreadPoolServer(
                    new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting server on port "+ PORT);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
