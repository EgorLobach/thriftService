package handler;

import aipos.bookService.BookService;
import aipos.model.Book;
import org.apache.thrift.TException;

import java.util.List;

public class BookHandler implements BookService.Iface{
    @Override
    public Book addBook(Book book) throws TException {
        return null;
    }

    @Override
    public Book getBook(String name) throws TException {
        return null;
    }

    @Override
    public Book updateBook(Book book) throws TException {
        return null;
    }

    @Override
    public Book deleteBook(String name) throws TException {
        return null;
    }

    @Override
    public List<Book> getBooks() throws TException {
        return null;
    }
}
