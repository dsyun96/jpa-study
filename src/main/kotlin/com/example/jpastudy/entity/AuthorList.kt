package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
class AuthorList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var age: Int = 0
    var genre: String = ""
    var name: String = ""

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "author_book_list",
        joinColumns = [JoinColumn(name = "author_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    var books: MutableList<BookList> = mutableListOf()

    fun addBook(book: BookList) {
        books.add(book)
        book.authors.add(this)
    }

    fun removeBook(book: BookList) {
        books.remove(book)
        book.authors.remove(this)
    }

    fun removeBooks() {
        val iterator = books.iterator()

        while (iterator.hasNext()) {
            val book = iterator.next()

            book.authors.remove(this)
            iterator.remove()
        }
    }
}
