package com.example.jpastudy.repository

import com.example.jpastudy.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    fun findByAgeGreaterThanEqual(age: Int): List<Author>
}
