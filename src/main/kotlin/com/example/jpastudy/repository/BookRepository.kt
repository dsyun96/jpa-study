package com.example.jpastudy.repository

import com.example.jpastudy.entity.Book
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface BookRepository : JpaRepository<Book, Long> {
    @Transactional
    @Query(
        value = "SELECT b FROM Book b LEFT JOIN FETCH b.author WHERE b.isbn LIKE ?1%",
        countQuery = "SELECT COUNT(b) FROM Book b WHERE b.isbn LIKE ?1%"
    )
    fun fetchWithAuthorsByIsbn(isbn: String, pageable: Pageable): Page<Book>
}
