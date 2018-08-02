package app.library

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Book {
    @Id
    String id
    String bookName
    Integer noOfCopies
    String location
    Date date
}
