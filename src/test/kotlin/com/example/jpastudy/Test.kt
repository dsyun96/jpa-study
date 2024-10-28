package com.example.jpastudy

import com.example.jpastudy.repository.AuthorRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

@SpringBootTest
class Test {
    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Test
    fun test() {
        authorRepository.fetchAllNative()
    }

    @Test
    fun pageableTest() {
        val pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "id"))
        authorRepository.fetchAll(pageable)
    }
}
