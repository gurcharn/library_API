package app.library

import app.library.Book
import app.library.BookRepository
import app.library.LibraryController
import spock.lang.Specification

class LibraryControllerTest extends Specification{

    LibraryController libraryController
    Book book
    String bookName
    BookRepository bookRepository

    def setup(){
        bookName = "abc"
        book = new Book(bookName: bookName)
        bookRepository = Mock(BookRepository)
        libraryController = new LibraryController(bookRepository: bookRepository)
    }

    def "should call repository when no book name passed"(){
        when:
        libraryController.listBooks()
        then:
        1*bookRepository.findAll()
    }

    def "should call repository when book name passed"(){
        when:
        libraryController.listBooks(bookName)
        then:
        1*bookRepository.findByBookName(bookName)
    }
}
