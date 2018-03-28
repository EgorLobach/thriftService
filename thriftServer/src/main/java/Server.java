import aipos.bookService.BookService;
import handler.BookHandler;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server {
    private static final int PORT = 9090;

    private static BookService.Processor processor;

    public static void main(String[] args) {
        BookHandler bookHandler = new BookHandler();
        processor = new BookService.Processor(bookHandler);
        Runnable server  =  () -> start(processor);
        new Thread(server).start();
    }

    private static void start(BookService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(PORT);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the server on port " + PORT + "...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
