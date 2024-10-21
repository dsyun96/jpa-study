package com.example.jpastudy

import com.example.jpastudy.repository.AuthorRepository
import com.example.jpastudy.repository.BookRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@SpringBootTest
class Test {
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Test
    fun testAuthor() {
        val pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "name"))
        val authors = authorRepository.fetchWithBooksByGenre("History", pageable)

        println(authors)
    }

    @Test
    fun testBook() {
        val pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "title"))
        val books = bookRepository.fetchWithAuthorsByIsbn("001-", pageable)

        println(books)
    }
}
