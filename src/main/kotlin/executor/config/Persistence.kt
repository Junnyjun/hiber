package executor.config

import executor.team.Team
import org.hibernate.jpa.HibernatePersistenceProvider
import java.net.URL
import java.util.*
import javax.persistence.SharedCacheMode
import javax.persistence.ValidationMode
import javax.persistence.spi.ClassTransformer
import javax.persistence.spi.PersistenceUnitInfo
import javax.persistence.spi.PersistenceUnitTransactionType
import javax.sql.DataSource

private val probs: Properties = Properties().also {
    it.setProperty("javax.persistence.jdbc.url", "jdbc:postgresql://129.154.196.125:5432/mydb")
    it.setProperty("javax.persistence.jdbc.user", "junny")
    it.setProperty("javax.persistence.jdbc.password", "1234")
    it.setProperty("javax.persistence.jdbc.driver", "org.postgresql.Driver")
    it.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
    it.setProperty("hibernate.hbm2ddl.auto", "create")
    it.setProperty("hibernate.show_sql", "true")
    it.setProperty("hibernate.format_sql", "true") }


val emf = HibernatePersistenceProvider().createContainerEntityManagerFactory(
    Persistence,
    Collections.EMPTY_MAP
)

object Persistence:PersistenceUnitInfo {


    override fun getProperties(): Properties {
        return probs
    }

    override fun getManagedClassNames(): List<String?>? {
        return mutableListOf(
            Team::class.java.name,
        )
    }

    override fun getPersistenceUnitName(): String? {
        return "TestUnit"
    }

    override fun getPersistenceProviderClassName(): String? {
        return HibernatePersistenceProvider::class.java.name
    }

    override fun getTransactionType(): PersistenceUnitTransactionType? {
        return null
    }

    override fun getJtaDataSource(): DataSource? {
        return null
    }

    override fun getNonJtaDataSource(): DataSource? {
        return null
    }

    override fun getMappingFileNames(): List<String?>? {
        return null
    }

    override fun getJarFileUrls(): List<URL?>? {
        return null
    }

    override fun getPersistenceUnitRootUrl(): URL? {
        return null
    }

    override fun excludeUnlistedClasses(): Boolean {
        return false
    }

    override fun getSharedCacheMode(): SharedCacheMode? {
        return null
    }

    override fun getValidationMode(): ValidationMode? {
        return null
    }

    override fun getPersistenceXMLSchemaVersion(): String? {
        return null
    }

    override fun getClassLoader(): ClassLoader? {
        return null
    }

    override fun addTransformer(transformer: ClassTransformer?) {}

    override fun getNewTempClassLoader(): ClassLoader? {
        return null
    }
}