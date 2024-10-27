package com.example.jpastudy.entity

import jakarta.persistence.*

@Entity
class AuthorSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var age: Int = 0
    var genre: String = ""
    var name: String = ""

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "author_book_set",
        joinColumns = [JoinColumn(name = "author_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    var books: MutableSet<BookSet> = HashSet()

    fun addBook(book: BookSet) {
        books.add(book)
        book.authors.add(this)
    }

    fun removeBook(book: BookSet) {
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
