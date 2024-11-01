package com.example.jpastudy.repository

import com.example.jpastudy.entity.Publisher
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface PublisherRepository : JpaRepository<Publisher, Long> {
    @EntityGraph(
        attributePaths = ["books.author"],
        type = EntityGraph.EntityGraphType.FETCH
    )
    override fun findAll(): List<Publisher>
}
