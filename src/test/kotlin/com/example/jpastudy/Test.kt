package com.example.jpastudy

import com.example.jpastudy.repository.AuthorRepository
import com.example.jpastudy.repository.PublisherRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Test {
    @Autowired
    private lateinit var publisherRepository: PublisherRepository

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Test
    fun test() {
        authorRepository.findAll()
    }

    @Test
    fun test2() {
        publisherRepository.findAll()
    }
}
