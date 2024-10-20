package com.example.jpastudy.ds2

import com.example.jpastudy.ds1.Author
import jakarta.persistence.*

@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var isbn: String = ""
    var title: String = ""
    var authors: String = ""
}
