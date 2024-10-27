package com.example.jpastudy.service

import com.example.jpastudy.entity.Book
import com.example.jpastudy.repository.AuthorRepository
import com.example.jpastudy.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookstoreService(
    private val authorRepository : AuthorRepository,
    private val bookRepository: BookRepository
) {
    @Transactional
    fun insertNewBook(): Book {
        val author = authorRepository.getReferenceById(4L)

        val book = Book().apply {
            isbn = "003-JN"
            title = "History Of Present"
            this.author = author
        }

        return bookRepository.save(book)
    }

    @Transactional
    fun updateBook() {
        val book = insertNewBook()

        book.isbn = "not available"
    }
}
