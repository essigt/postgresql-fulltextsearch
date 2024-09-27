package de.synyx.essig.KotlinModulith

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer


open class IntegrationTest {

    companion object {
        val postgres = PostgreSQLContainer("postgres:16.0")

        @JvmStatic
        @BeforeAll
        fun startPostgres() = postgres.start()

        @JvmStatic
        @AfterAll
        fun stopPostgres() = postgres.stop()

        @JvmStatic
        @DynamicPropertySource
        fun registerDBContainer(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgres::getJdbcUrl)
            registry.add("spring.datasource.username", postgres::getUsername)
            registry.add("spring.datasource.password", postgres::getPassword)
        }
    }

}