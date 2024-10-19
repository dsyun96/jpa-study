package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var age: Int = 0
    var genre: String = ""
    var name: String = ""

    @OneToMany(
        cascade = [(CascadeType.ALL)],
        orphanRemoval = true
    )
//    @OrderColumn(name = "books_order")
    @JoinColumn(name = "author_id")
    val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun removeBook(book: Book) {
        books.remove(book)
    }
}
