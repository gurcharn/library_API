package app.library

import org.springframework.data.mongodb.repository.MongoRepository

interface BookRepository extends MongoRepository<Book, String>{

    List<Book> findByBookName(String bookName)

}