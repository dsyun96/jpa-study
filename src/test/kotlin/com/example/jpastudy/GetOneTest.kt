package com.example.jpastudy

import com.example.jpastudy.entity.Book
import com.example.jpastudy.repository.AuthorRepository
import com.example.jpastudy.repository.BookRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GetOneTest {
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Test
    fun addBookToAuthor() {
        val author = authorRepository.getOne(1L)

        val book = Book()
        book.isbn = "001-MJ"
        book.title = "The Canterbury Anthology"
        book.author = author

        bookRepository.save(book)
    }
}
