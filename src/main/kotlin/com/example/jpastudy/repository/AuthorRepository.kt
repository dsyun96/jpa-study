package com.example.jpastudy.repository

import com.example.jpastudy.entity.Author
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
    @Query(
        value = "SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.genre = ?1",
        countQuery = "SELECT COUNT(a) FROM Author a WHERE a.genre = ?1",
    )
    fun fetchWithBooksByGenre(genre: String, pageable: Pageable): Page<Author>
}
