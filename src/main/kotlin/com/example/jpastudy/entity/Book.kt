package com.example.jpastudy.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
class Book : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    var isbn: String = ""
    var title: String = ""

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author: Author? = Author()

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }
        if (this === other) {
            return true
        }
        if (javaClass != other.javaClass) {
            return false
        }

        return id == (other as Book).id
    }

    override fun hashCode(): Int {
        return 2024
    }

    override fun toString(): String {
        return "Book(id=$id, title=$title, isbn=$isbn)"
    }
}
