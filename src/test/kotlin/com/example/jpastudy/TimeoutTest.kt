package com.example.jpastudy

import com.example.jpastudy.service.AuthorService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TimeoutTest {
    @Autowired
    private lateinit var authorService: AuthorService

    @Test
    fun test() {
        authorService.newAuthor()
    }
}
