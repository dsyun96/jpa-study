package com.example.jpastudy.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
class Author : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    val age: Int = 0
    val genre: String = ""
    val name: String = ""

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "author",
        orphanRemoval = true
    )
    val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
        book.author = this
    }

    fun removeBook(book: Book) {
        book.author = null
        books.remove(book)
    }

    fun removeBooks() {
        val iterator = books.iterator()

        while (iterator.hasNext()) {
            val book = iterator.next()
            book.author = null
            iterator.remove()
        }
    }

    override fun toString(): String {
        return "Author(id=$id, age=$age, genre=$genre, name=$name)"
    }
}
