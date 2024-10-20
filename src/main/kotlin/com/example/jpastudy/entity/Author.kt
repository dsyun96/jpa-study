package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 100000)
    var avatar: ByteArray? = null

    var age: Int = 0
    var genre: String = ""
    var name: String = ""
}
