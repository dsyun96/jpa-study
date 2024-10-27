package com.example.jpastudy.repository

import com.example.jpastudy.entity.AuthorSet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorSetRepository : JpaRepository<AuthorSet, Long>
