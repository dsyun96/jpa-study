package com.example.jpastudy

import com.example.jpastudy.service.AuthorBookService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Test {
    @Autowired
    private lateinit var authorBookService: AuthorBookService

    @Test
    fun test() {
        authorBookService.persistAuthor()
        authorBookService.persistBook()
    }
}
