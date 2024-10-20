package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths


@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {
    @Transactional
    fun createAvatars() {
        val mt = Author().apply {
            name = "Martin Ticher"
            age = 43
            genre = "Horror"
            avatar = Files.readAllBytes(Paths.get("src\\main\\resources\\avatars\\mt.png"))
        }
        val cd = Author().apply {
            name = "Carla Donnoti"
            age = 31
            genre = "Science Fiction"
            avatar = Files.readAllBytes(Paths.get("src\\main\\resources\\avatars\\cd.png"))
        }
        val re = Author().apply {
            name = "Rennata Elibol"
            age = 46
            genre = "Fantasy"
            avatar = Files.readAllBytes(Paths.get("src\\main\\resources\\avatars\\re.png"))
        }

        authorRepository.save(mt)
        authorRepository.save(cd)
        authorRepository.save(re)
    }

    fun fetchAuthorsByAgeGreaterThanEqual(age: Int): List<Author> {
        val authors: List<Author> = authorRepository.findByAgeGreaterThanEqual(age)

        return authors
    }
}
