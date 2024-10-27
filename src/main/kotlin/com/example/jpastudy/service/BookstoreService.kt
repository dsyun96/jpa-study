package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class BookstoreService(
    private val authorRepository : AuthorRepository
) {
    fun fetchWithBooksBy(genre: String, page: Int, size: Int): Page<Author> {
        return authorRepository.fetchWithBooksByGenre(
            genre = genre,
            pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"))
        )
    }
}
