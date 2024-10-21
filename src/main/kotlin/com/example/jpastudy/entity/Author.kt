package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "author", orphanRemoval = true)
    val books: List<Book> = ArrayList()

    val age: Int = 0
    val genre: String = ""
    val name: String = ""
}
