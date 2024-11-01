package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
@NamedEntityGraph(
    name = "author-books-publisher-graph",
    attributeNodes = [
        NamedAttributeNode(
            value = "books",
            subgraph = "publisher-subgraph"
        )
    ],
    subgraphs = [
        NamedSubgraph(
            name = "publisher-subgraph",
            attributeNodes = [
                NamedAttributeNode("publisher")
            ]
        )
    ]
)
class Author {
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
