package com.example.jpastudy.service

import com.example.jpastudy.entity.Author
import com.example.jpastudy.repository.AuthorRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Consumer


@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Transactional
    fun fetchAuthorReadWriteMode(): Author? {
        println("Persistent Context before fetching read-write entity:")
        briefOverviewOfPersistentContextContent()

        val author = authorRepository.findByName("Joana Nimar")

        println("\n\nPersistent Context after fetching read-write entity:")
        briefOverviewOfPersistentContextContent()

        return author
    }

    private fun briefOverviewOfPersistentContextContent() {
        val persistenceContext: org.hibernate.engine.spi.PersistenceContext = getPersistenceContext()

        val managedEntities = persistenceContext.numberOfManagedEntities
        val collectionEntries: Map<*, *>? = persistenceContext.collectionEntries

        println("\n-----------------------------------")
        println("Total number of managed entities: $managedEntities")
        if (collectionEntries != null) {
            println(
                "Total number of collection entries: "
                        + (collectionEntries.values.size)
            )
        }

        val entities: Map<*, *> = persistenceContext.entitiesByKey
        entities.forEach { (key: Any?, value: Any?) -> println(key.toString() + ":" + value) }

        entities.values.forEach(Consumer { entry: Any? ->
            val ee = persistenceContext.getEntry(entry!!)
            println(
                ("Entity name: " + ee.entityName
                        + " | Status: " + ee.status
                        + " | State: " + ee.loadedState.contentToString())
            )
        })

        println("\n-----------------------------------\n")
    }

    private fun getPersistenceContext(): org.hibernate.engine.spi.PersistenceContext {
        val sharedSession: SharedSessionContractImplementor = entityManager.unwrap(
            SharedSessionContractImplementor::class.java
        )

        return sharedSession.persistenceContext
    }
}
