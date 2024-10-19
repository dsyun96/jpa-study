package com.example.jpastudy.repository

import com.example.jpastudy.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface AuthorRepository : JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.name = ?1")
    fun fetchByName(name: String): Author?
}
