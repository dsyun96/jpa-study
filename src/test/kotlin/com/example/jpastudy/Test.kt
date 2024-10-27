package com.example.jpastudy

import com.example.jpastudy.service.BookstoreService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Test {
    @Autowired
    private lateinit var bookstoreService: BookstoreService

    @Test
    fun insertNewBook() {
        bookstoreService.insertNewBook()
    }

    @Test
    fun updateBook() {
        bookstoreService.updateBook()
    }

    @Test
    fun fetchBooksOfAuthorsById() {
        bookstoreService.fetchBooksOfAuthorById(4L)
    }

    @Test
    fun fetchPageBooksOfAuthorsById() {
        bookstoreService.fetchPageBooksOfAuthorById(4L)
    }

    @Test
    fun fetchBooksOfAuthorsByIdAndAddNewBook() {
        bookstoreService.fetchBooksOfAuthorsByIdAndAddNewBook(4L)
    }
}
