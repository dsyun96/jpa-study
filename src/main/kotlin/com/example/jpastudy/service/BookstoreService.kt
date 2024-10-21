package com.example.jpastudy.service

import com.example.jpastudy.dto.AuthorDto
import com.example.jpastudy.repository.AuthorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class BookstoreService(
    private val authorRepository : AuthorRepository
) {
    fun fetchNextPageJpql(page: Int, size: Int): Page<AuthorDto> {
        val pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "age"))

        val authors = authorRepository.fetchAllJpql(pageable)
        val pageOfAuthors = PageImpl(
            authors,
            pageable,
            if (authors.isEmpty()) 0 else authors[0].total
        )

        return pageOfAuthors
    }
}
