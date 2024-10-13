package com.example.jpastudy

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import jakarta.persistence.EntityManager
import org.hibernate.engine.spi.PersistenceContext
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class TransactionalTest {
    @Autowired
    private lateinit var entityManager: EntityManager

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Test
    @Transactional
    fun fetchAuthorReadWriteMode() {
        testCode()
    }

    @Test
    @Transactional(readOnly = true)
    fun fetchAuthorReadOnlyMode() {
        testCode()
    }

    private fun testCode() {
        val author = authorRepository.findFirstByGenre("Anthology")

        displayInformation("After Fetch", author)

        author.age = 40

        displayInformation("After Update Entity", author)

        authorRepository.flush()

        displayInformation("After Flush", author)
    }

    private fun displayInformation(phase: String, author: Author) {
        println("-".repeat(50))

        println("Phase: $phase\nAuthor: $author")

        val persistenceContext = getPersistenceContext()
        val entityEntry = persistenceContext.getEntry(author)
        val loadedState = entityEntry.loadedState ?: null
        val status = entityEntry.status

        println("Entity entry: $entityEntry")
        println("Status: $status")
        println("Loaded state: ${loadedState?.contentToString()}")

        println("-".repeat(50))
    }

    private fun getPersistenceContext(): PersistenceContext {
        val sharedSession = entityManager.unwrap(SharedSessionContractImplementor::class.java)

        return sharedSession.persistenceContext
    }
}
