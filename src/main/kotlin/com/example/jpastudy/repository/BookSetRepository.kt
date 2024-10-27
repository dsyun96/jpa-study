package com.example.jpastudy.repository

import com.example.jpastudy.entity.BookSet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookSetRepository : JpaRepository<BookSet, Long>
