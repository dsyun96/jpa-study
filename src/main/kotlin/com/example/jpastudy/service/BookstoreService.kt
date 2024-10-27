package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import org.springframework.data.domain.*
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

    @Transactional
    fun fetchPageOfAuthorsWithBooksByGenreTuple(genre: String, page: Int, size: Int): Page<Author> {
        val pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"))

        val tuples = authorRepository.fetchTupleOfIdsByGenre(genre, pageable)
        val listOfIds = MutableList(tuples.size) { 0L }

        tuples.forEach { tuple ->
            listOfIds.add(tuple.get("id") as Long)
        }

        val listOfAuthors = authorRepository.fetchWithBooksJoinFetch(listOfIds)
        val pageOfAuthors = PageImpl(listOfAuthors, pageable, tuples[0].get("total") as Long)

        return pageOfAuthors
    }

    @Transactional
    fun fetchSliceAuthorsWithBooksByGenre(genre: String, page: Int, size: Int): Slice<Author> {
        val pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"))

        val pageOfIds = authorRepository.fetchSliceOfIdsByGenre(genre, pageable)
        val listOfAuthors = authorRepository.fetchWithBooks(pageOfIds.content)
        val sliceOfAuthors = SliceImpl(listOfAuthors, pageable, pageOfIds.hasNext())

        return sliceOfAuthors
    }
}
