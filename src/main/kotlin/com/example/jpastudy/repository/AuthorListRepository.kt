package com.example.jpastudy.repository

import com.example.jpastudy.entity.AuthorList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorListRepository : JpaRepository<AuthorList, Long>
