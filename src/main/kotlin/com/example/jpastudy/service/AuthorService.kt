package com.example.jpastudy.service

import com.example.jpastudy.repository.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {
    @Transactional
    fun deleteLastBook() {
        val author = authorRepository.fetchByName("Joana Nimar") ?: throw IllegalArgumentException()
        val books = author.books

        author.removeBook(books[books.size - 1])
    }

    @Transactional
    fun deleteFirstBook() {
        val author = authorRepository.fetchByName("Joana Nimar") ?: throw IllegalArgumentException()
        val books = author.books

        author.removeBook(books[0])
    }
}
