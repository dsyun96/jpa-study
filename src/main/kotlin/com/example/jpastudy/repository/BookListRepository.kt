package com.example.jpastudy.repository

import com.example.jpastudy.entity.BookList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookListRepository : JpaRepository<BookList, Long>
