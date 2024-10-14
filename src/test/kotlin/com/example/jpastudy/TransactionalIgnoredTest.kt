package com.example.jpastudy

import com.example.jpastudy.service.BookstoreService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransactionalIgnoredTest {
    @Autowired
    private lateinit var bookstoreService: BookstoreService

    @Test
    fun test() {
        bookstoreService.mainAuthor()
    }
}
