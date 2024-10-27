package com.example.jpastudy

import com.example.jpastudy.service.BookstoreService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Test {
    @Autowired
    private lateinit var bookstoreService: BookstoreService

    @Test
    fun fetchWithBooksBy() {
        bookstoreService.fetchWithBooksBy("Anthology", 0, 3)
    }

    @Test
    fun fetchAuthorsWithBooksByGenre() {
        val authors = bookstoreService.fetchAuthorsWithBooksByGenre("Anthology", 0, 3)
        val objectMapper = ObjectMapper().writerWithDefaultPrettyPrinter()

        println(objectMapper.writeValueAsString(authors))
    }

    @Test
    fun fetchPageOfAuthorsWithBooksByGenreTuple() {
        bookstoreService.fetchPageOfAuthorsWithBooksByGenreTuple("Anthology", 0, 3)
    }
}
