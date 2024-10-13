package com.example.jpastudy.entity

import javax.persistence.*


@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author: Author = Author()

    var isbn: String = ""
    var title: String = ""
}
