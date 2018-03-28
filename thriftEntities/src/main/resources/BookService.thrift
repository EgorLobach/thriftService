namespace java aipos.bookService

include "Book.thrift"

service BookService{
    Book.Book addBook(1: Book.Book book);

    Book.Book getBook(1: string name);

    Book.Book updateBook(1: Book.Book book);

    Book.Book deleteBook(1: string name);

    list <Book.Book> getBooks();

}



