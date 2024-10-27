package com.example.jpastudy.repository

import com.example.jpastudy.entity.Book
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface BookRepository : JpaRepository<Book, Long> {
    @Transactional(readOnly = true)
    @Query("SELECT b FROM Book b WHERE b.author.id = :authorId")
    fun fetchBooksOfAuthorsById(authorId: Long): List<Book>

    @Transactional(readOnly = true)
    @Query("SELECT b FROM Book b WHERE b.author.id = :authorId")
    fun fetchPageBooksOfAuthorsById(authorId: Long, pageable: Pageable): List<Book>
}
