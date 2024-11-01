package com.example.jpastudy.repository

import com.example.jpastudy.entity.Author
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface AuthorRepository : JpaRepository<Author, Long> {
    @EntityGraph(
        value = "author-books-graph",
        type = EntityGraph.EntityGraphType.FETCH
    )
    fun findByAgeGreaterThanAndGenre(age: Int, genre: String): List<Author>

    @EntityGraph(
        value = "author-books-graph",
        type = EntityGraph.EntityGraphType.LOAD
    )
    fun findByGenreAndAgeGreaterThan(genre: String, age: Int): List<Author>
}
