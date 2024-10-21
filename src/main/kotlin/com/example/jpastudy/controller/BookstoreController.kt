package com.example.jpastudy.controller

import com.example.jpastudy.dto.AuthorDto
import com.example.jpastudy.service.BookstoreService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BookstoreController(
    private val bookstoreService: BookstoreService
) {
    @GetMapping("/jpql/authors/{page}/{size}")
    fun fetchAuthorsJpql(
        @PathVariable page: Int,
        @PathVariable size: Int
    ): Page<AuthorDto> {
        return bookstoreService.fetchNextPageJpql(page, size)
    }
}
