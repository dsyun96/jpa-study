package com.example.jpastudy.dto

import com.fasterxml.jackson.annotation.JsonIgnore

interface AuthorDto {
    val name: String
    val age: Int

    @get:JsonIgnore
    val total: Long
}
