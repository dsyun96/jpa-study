package com.example.jpastudy.repository

import com.example.jpastudy.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
    fun findByName(name: String): Author?
}
