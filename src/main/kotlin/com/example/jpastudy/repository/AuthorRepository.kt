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
        attributePaths = ["books.publisher"],
        type = EntityGraph.EntityGraphType.FETCH
    )
    override fun findAll(): List<Author>
}
