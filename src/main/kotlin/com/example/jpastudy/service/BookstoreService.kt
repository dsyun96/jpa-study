package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import org.springframework.stereotype.Service

@Service
class BookstoreService(
    private val helperService: HelperService
) {
    fun mainAuthor() {
        val author = Author()

        helperService.persistAuthor(author)
        notifyAuthor(author)
    }

    private fun notifyAuthor(author: Author) {
        println("Saving author: $author")
    }
}
