package com.example.jpastudy.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var age: Int = 0
    val genre: String = ""
    val name: String = ""

    override fun toString(): String {
        return "Author(id=$id, age=$age, genre=$genre, name=$name)"
    }
}
