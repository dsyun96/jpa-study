package com.example.jpastudy.repository

import com.example.jpastudy.dto.AuthorDto
import com.example.jpastudy.entity.Author
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
    @Query(value = "SELECT a.name as name, a.age as age, (SELECT count(a) FROM Author a) AS total FROM Author a")
    fun fetchAllJpql(pageable: Pageable): List<AuthorDto>
}
