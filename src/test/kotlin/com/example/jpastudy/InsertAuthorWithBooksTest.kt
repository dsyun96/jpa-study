package com.example.jpastudy

import com.example.jpastudy.entity.Author
import com.example.jpastudy.entity.Book
import com.example.jpastudy.repository.AuthorRepository
import com.example.jpastudy.service.AuthorService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InsertAuthorWithBooksTest {
    @Autowired
    private lateinit var authorService: AuthorService

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Test
    fun test() {
        val jn = Author().apply {
            name = "Joana Nimar"
            age = 34
            genre = "History"
        }

        val jn01 = Book().apply {
            isbn = "001-JN"
            title = "A History of Ancient Prague"
        }
        val jn02 = Book().apply {
            isbn = "002-JN"
            title = "A People's History"
        }
        val jn03 = Book().apply {
            isbn = "003-JN"
            title = "World History"
        }

        jn.addBook(jn01)
        jn.addBook(jn02)
        jn.addBook(jn03)

        authorRepository.save(jn)
    }

    @Test
    fun insertNewBook() {
        val author = authorRepository.fetchByName("Joana Nimar") ?: throw IllegalArgumentException()

        val book = Book().apply {
            isbn = "004-JN"
            title = "History Details"
        }

        author.addBook(book)

        authorRepository.save(author)
    }

    @Test
    fun deleteLastBook() {
        authorService.deleteLastBook()
    }

    @Test
    fun deleteFirstBook() {
        authorService.deleteFirstBook()
    }
}
