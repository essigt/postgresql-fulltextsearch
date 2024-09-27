package de.synyx.essig.KotlinModulith.search.repository

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY
import java.time.ZonedDateTime

@Entity
@Table(name = "articles")
data class Article(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,

    val timestamp: ZonedDateTime,

    val author: String,

    val titel: String,
    
    val content: String,
)
