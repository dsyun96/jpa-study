package com.example.jpastudy

import com.example.jpastudy.entity.Book
import com.example.jpastudy.repository.AuthorRepository
import com.example.jpastudy.repository.BookRepository
import jakarta.transaction.Transactional
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
    @Transactional
    fun addBookToAuthor() {
        /**
         * getOne이 deprecated 되어 있고, 무엇보다 실행했을 때 select 문이 실행 됨
         * h2라서 그런 건지, 버전이 달라서 그런 건지는 모르겠음
         */
        val author = authorRepository.getOne(1L)

        val book = Book()
        book.isbn = "001-MJ"
        book.title = "The Canterbury Anthology"
        book.author = author

        bookRepository.save(book)
    }
}
