package de.synyx.essig.KotlinModulith.search.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : CrudRepository<Article, Long> {
    fun findByAuthorLikeOrContentLike(
        author: String,
        content: String,
    ): List<Article>

    @Query(
        value = "SELECT * " +
                "FROM articles " +
                "WHERE ts @@ plainto_tsquery('german',:query)", nativeQuery = true
    )
    fun search(query: String): List<Article>

    @Query(
        value = "SELECT *, ts_rank_cd(ts, query) AS rank " +
                "FROM articles, plainto_tsquery('german',:query) query " +
                "WHERE query @@ ts " +
                "ORDER BY rank DESC " +
                "LIMIT 10;", nativeQuery = true
    )
    fun searchTop10(query: String): List<Article>
}
