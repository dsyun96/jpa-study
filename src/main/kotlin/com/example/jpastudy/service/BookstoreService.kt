package com.example.jpastudy.service

import com.example.jpastudy.entity.AuthorList
import com.example.jpastudy.entity.BookList
import com.example.jpastudy.repository.AuthorListRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class BookstoreService(
    private val authorListRepository : AuthorListRepository
) {
    @Transactional
    fun persistAuthorWithBooksAndRemoveOneBookList() {
        val alicia = AuthorList().apply {
            name = "Alicia Tom"
            age = 38
            genre = "Anthology"
        }

        val mark = AuthorList().apply {
            name = "Mark Janel"
            age = 23
            genre = "Anthology"
        }

        val bookOfSwords = BookList().apply {
            isbn = "001-AT-MJ"
            title = "The book of swords"
        }

        val oneDay = BookList().apply {
            isbn = "002-AT-MJ"
            title = "One Day"
        }

        val headDown = BookList().apply {
            isbn = "001-AT"
            title = "Head Down"
        }

        alicia.addBook(bookOfSwords)
        mark.addBook(bookOfSwords)
        alicia.addBook(oneDay)
        mark.addBook(oneDay)
        alicia.addBook(headDown)

        authorListRepository.save(alicia)
        authorListRepository.saveAndFlush(mark)

        println("================================================")
        println("Removing a book (List case) ...")
        println("================================================")

        alicia.removeBook(oneDay)
    }
}
