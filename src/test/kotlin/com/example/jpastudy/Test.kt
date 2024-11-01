package com.example.jpastudy

import com.example.jpastudy.repository.AuthorRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Test {
    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Test
    fun findByAgeGreaterThanAndGenre() {
        authorRepository.findByAgeGreaterThanAndGenre(30, "history")
    }

    @Test
    fun findByGenreAndAgeGreaterThan() {
        authorRepository.findByGenreAndAgeGreaterThan("history", 30)
    }
}
