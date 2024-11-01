package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
@NamedEntityGraph(
    name = "author-books-graph",
    attributeNodes = [
        NamedAttributeNode("name"),
        NamedAttributeNode("books")
    ]
)
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Basic(fetch = FetchType.LAZY)
    val age: Int = 0
    @Basic(fetch = FetchType.LAZY)
    val genre: String = ""

    val name: String = ""

    @OneToMany(
        cascade = [(CascadeType.ALL)],
        mappedBy = "author",
        orphanRemoval = true
    )
    var books: MutableList<Book> = mutableListOf()
}
