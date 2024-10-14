package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class HelperService(
    private val authorRepository : AuthorRepository
) {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun persistAuthor(author: Author): Long {
        authorRepository.save(author)
        return authorRepository.count()
    }
}
