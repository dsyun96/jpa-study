package com.example.jpastudy.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.NamedNativeQueries
import org.hibernate.annotations.NamedNativeQuery
import org.hibernate.annotations.NamedQueries
import org.hibernate.annotations.NamedQuery

@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    val age: Int = 0
    val genre: String = ""
    val name: String = ""
}
