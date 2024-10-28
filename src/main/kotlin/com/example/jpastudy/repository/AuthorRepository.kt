package com.example.jpastudy.repository

import com.example.jpastudy.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface AuthorRepository : JpaRepository<Author, Long> {
    fun fetchAll(): List<Author>
    fun fetchByNameAndAge(name: String, age: Int): Author

    @Query(nativeQuery = true)
    fun fetchAllNative(): List<Author>
}
