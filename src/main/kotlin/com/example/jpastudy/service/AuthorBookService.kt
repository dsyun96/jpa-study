package com.example.jpastudy.service

import com.example.jpastudy.ds1.Author
import com.example.jpastudy.ds1.AuthorRepository
import com.example.jpastudy.ds2.Book
import com.example.jpastudy.ds2.BookRepository
import org.springframework.stereotype.Service

@Service
class AuthorBookService(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository
) {
    fun persistAuthor(): Author {
        val author = Author().apply {
            name = "Joana Nimar"
            genre = "History"
            age = 34
            books = "Anthology Of 1970"
        }

        return authorRepository.save(author)
    }

    fun persistBook(): Book {
        val book = Book().apply {
            isbn = "001-AT"
            title = "Antholoy Of 1970"
            authors = "Alicia Tom"
        }

        return bookRepository.save(book)
    }
}
