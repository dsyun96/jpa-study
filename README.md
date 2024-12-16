**요약**
```kotlin
class DatabaseTableMetadataExtractor : Integrator {
    private var database: Database? = null

    override fun integrate(
        metadata: Metadata,
        bootstrapContext: BootstrapContext,
        sessionFactory: SessionFactoryImplementor
    ) {
        database = metadata.database
    }

    override fun disintegrate(
        sessionImplementor: SessionFactoryImplementor,
        serviceRegistry: SessionFactoryServiceRegistry
    ) {
    }

    fun getDatabase(): Database? {
        return database
    }

    companion object {
        val EXTRACTOR: DatabaseTableMetadataExtractor = DatabaseTableMetadataExtractor()
    }
}
```
- `LocalContainerEntityManagerFactoryBean`을 통해서 위의 Integrator를 등록
