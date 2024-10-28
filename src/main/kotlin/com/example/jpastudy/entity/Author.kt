package com.example.jpastudy.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.NamedNativeQueries
import org.hibernate.annotations.NamedNativeQuery
import org.hibernate.annotations.NamedQueries
import org.hibernate.annotations.NamedQuery

@NamedQueries(*[
    NamedQuery(
        name = "Author.fetchAll",
        query = "SELECT a FROM Author a"
    ),
    NamedQuery(
        name = "Author.fetchByNameAndAge",
        query = "SELECT a FROM Author a WHERE a.name = ?1 AND a.age = ?2"
    )
])
@NamedNativeQueries(*[
    NamedNativeQuery(
        name = "Author.fetchAllNative",
        query = "SELECT * FROM author",
        resultClass = Author::class
    )
])
@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    val age: Int = 0
    val genre: String = ""
    val name: String = ""
}
