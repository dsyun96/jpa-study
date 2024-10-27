package com.example.jpastudy.service

import com.example.jpastudy.entity.Book
import com.example.jpastudy.repository.AuthorRepository
import com.example.jpastudy.repository.BookRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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

    @Transactional
    fun fetchBooksOfAuthorById(authorId: Long) {
        val books = bookRepository.fetchBooksOfAuthorsById(authorId)

        books.forEach { book -> println(book) }
    }

    @Transactional
    fun fetchPageBooksOfAuthorById(authorId: Long) {
        val books = bookRepository.fetchPageBooksOfAuthorsById(
            authorId = authorId,
            pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "title"))
        )

        books.forEach { book -> println(book) }
    }
}
