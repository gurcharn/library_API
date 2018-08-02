package app.library

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/store")
class LibraryController {

    @Autowired
    BookRepository bookRepository

    @GetMapping
    List<Book> listBooks(@RequestParam(value = "bookName", required =false) String bookName){

        if(bookName)
            bookRepository.findByBookName(bookName)

        else
             bookRepository.findAll()
    }

    @PostMapping
    void newBook(@RequestBody Book book){
        validateBook(book)

        bookRepository.insert(book)
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/{bookName}")
    void removeBook(@PathVariable String bookName){
        Book bookToDelete = bookRepository.findByBookName(bookName)

        if(bookToDelete)
            bookRepository.delete(bookToDelete)
    }


    void validateBook(Book book){
        if(!book)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST , "Book Validation Failed")
    }

//    private void translatePerson(Book person, Book updateBook) {
//        person.name = updatePerson.name
//        person.age= updatePerson.age
//        person.dob = updatePerson.dob
//        person.status = updatePerson.status
//    }

}
