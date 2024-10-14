package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {
    @Transactional(timeout = 10)
    fun newAuthor() {
        val author = Author()
        author.age = 23
        author.genre = "Anthology"
        author.name = "Mark Janel"

        authorRepository.saveAndFlush(author)
        authorRepository.sleepQuery()

        println("The end!")
    }
}
