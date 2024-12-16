**요약**
```kotlin
@Service
class TestService {
    @PersistenceContext
    private lateinit var entityManager: EntityManager
    
    fun getPersistenceContext(): org.hibernate.engine.spi.PersistenceContext {
        val sharedSession = entityManager.unwrap(
            SharedSessionContractImplementor::class.java
        )
        
        return sharedSession.persistenceContext
    }
}
```
- number of managed entities : `getNumberOfManagedEntities()`
- number of collection entries : `getCollectionEntriesSize()`

```kotlin
fun briefOverviewOfPersistentContextContent() {
    val persistenceContext = getPersistenceContext()

    val managedEntities = persistenceContext.numberOfManagedEntities
    val collectionEntriesSize = persistenceContext.collectionEntriesSize

    println("Total number of managed entities: $managedEntities")
    println("Total number of collection entries: $collectionEntriesSize")

    val entitiesByKey = persistenceContext.entitiesByKey

    if (entitiesByKey.isNotEmpty()) {
        println("\nEntities by key:")

        entitiesByKey.forEach { (key, value) ->
            println("$key: $value")
        }

        println("\nStatus and hydrated state:")
        entitiesByKey.values.forEach { entry ->
            val ee = persistenceContext.getEntry(entry)
            println("Entity name: ${ee.entityName}")
            println("  | Status: ${ee.status}")
            println("  | State: ${ee.loadedState.contentToString()}")
        }
    }

    if (collectionEntriesSize > 0) {
        println("\nCollection entries:")

        persistenceContext.forEachCollectionEntry(
            { k: PersistentCollection<*>, v: CollectionEntry ->
                println("Key: $k, Value: ${v.takeIf { v.role != null } ?: ""}")
            }, false
        )
    }
}
```
