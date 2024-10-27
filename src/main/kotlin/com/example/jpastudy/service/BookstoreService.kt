package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    @Transactional(readOnly = true)
    fun fetchAuthorsWithBooksByGenre(genre: String, page: Int, size: Int): Page<Author> {
        val pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"))

        val pageOfIds = authorRepository.fetchPageOfIdsByGenre(genre, pageable)
        val listOfAuthors = authorRepository.fetchWithBooks(pageOfIds.content)
        val pageOfAuthors = PageImpl(listOfAuthors, pageable, pageOfIds.totalElements)

        return pageOfAuthors
    }
}
