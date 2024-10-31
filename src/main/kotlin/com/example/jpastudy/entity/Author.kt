package com.example.jpastudy.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@NamedEntityGraph(
    name = "author-books-graph",
    attributeNodes = [
        NamedAttributeNode("books")
    ]
)
class Author : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    val age: Int = 0
    val genre: String = ""
    val name: String = ""

    @OneToMany(
        cascade = [(CascadeType.ALL)],
        mappedBy = "author",
        orphanRemoval = true
    )
    var books: MutableList<Book> = mutableListOf()
}
