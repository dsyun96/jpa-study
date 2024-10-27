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
    fun persistAuthorWithBooksAndRemoveOneBookList() {
        bookstoreService.persistAuthorWithBooksAndRemoveOneBookList()
    }

    @Test
    fun persistAuthorWithBooksAndRemoveOneBookSet() {
        bookstoreService.persistAuthorWithBooksAndRemoveOneBookSet()
    }
}
