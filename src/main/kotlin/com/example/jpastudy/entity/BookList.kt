package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
class BookList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var isbn: String = ""
    var title: String = ""

    @ManyToMany(mappedBy = "books")
    var authors: MutableList<AuthorList> = mutableListOf()
}
