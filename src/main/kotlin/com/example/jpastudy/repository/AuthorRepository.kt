package com.example.jpastudy.repository

import com.example.jpastudy.entity.Author
import jakarta.persistence.QueryHint
import jakarta.persistence.Tuple
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
    @Query(
        value = "SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.genre = ?1",
        countQuery = "SELECT COUNT(a) FROM Author a WHERE a.genre = ?1",
    )
    fun fetchWithBooksByGenre(genre: String, pageable: Pageable): Page<Author>

    @Transactional(readOnly = true)
    @Query(value = "SELECT a.id FROM Author a WHERE a.genre = ?1")
    fun fetchPageOfIdsByGenre(genre: String, pageable: Pageable): Page<Long>

    @Transactional(readOnly = true)
    @Query(value = "SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id IN ?1")
    fun fetchWithBooks(authorIds: List<Long>): List<Author>

    @Transactional(readOnly = true)
    @Query(
        value = "SELECT a.id AS id, COUNT(*) OVER() AS total FROM author a WHERE a.genre = ?1",
        nativeQuery = true
    )
    fun fetchTupleOfIdsByGenre(genre: String, pageable: Pageable): List<Tuple>

    @Transactional(readOnly = true)
    @Query(value = "SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id IN ?1")
    fun fetchWithBooksJoinFetch(authorIds: List<Long>): List<Author>
}
