package com.example.jpastudy

import com.example.jpastudy.service.BookstoreService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.orm.jpa.JpaSystemException

@SpringBootTest
class Test {
    @Autowired
    private lateinit var bookstoreService: BookstoreService

    @Test
    fun fetchWithBooksBy() {
        assertThrows<JpaSystemException> {
            bookstoreService.fetchWithBooksBy("Anthology", 0, 3)
        }
    }
}
