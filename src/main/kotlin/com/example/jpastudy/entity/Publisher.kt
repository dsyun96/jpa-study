package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var company: String = ""

    @OneToMany(
        cascade = [(CascadeType.ALL)],
        mappedBy = "publisher",
        orphanRemoval = true
    )
    var books: MutableList<Book> = mutableListOf()
}
