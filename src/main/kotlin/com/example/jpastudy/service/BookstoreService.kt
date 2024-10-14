package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class BookstoreService(
    private val authorRepository : AuthorRepository
) {
    fun mainAuthor() {
        val author = Author()

        persistAuthor(author)
        notifyAuthor(author)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected fun persistAuthor(author: Author): Long {
        authorRepository.save(author)
        return authorRepository.count()
    }

    private fun notifyAuthor(author: Author) {
        println("Saving author: $author")
    }
}
