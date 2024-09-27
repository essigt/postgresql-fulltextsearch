package de.synyx.essig.KotlinModulith.orders.persistence

import de.synyx.essig.KotlinModulith.IntegrationTest
import de.synyx.essig.KotlinModulith.search.repository.ArticleRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class ArticleRepositoryIT(@Autowired private val articleRepository: ArticleRepository) : IntegrationTest() {

    @BeforeEach
    fun cleanUp() = articleRepository.deleteAll()

    @Test
    fun `can search articles by title`() {
        articleRepository.saveAll(ArticleFixture.ALL_EXAMPLE_ARTICLES)

        val articles = articleRepository.search("Flauschig")

        assertThat(articles).hasSize(1)
        assertThat(articles.first().titel).isEqualTo(ArticleFixture.EXAMPLE_ARTICLE_2.titel)
    }


    @Test
    fun `can persist`() {
        articleRepository.saveAll(ArticleFixture.ALL_EXAMPLE_ARTICLES)

        val articles = articleRepository.findAll()

        assertThat(articles).hasSize(3)
    }


    @Test
    fun `can search`() {
        articleRepository.saveAll(ArticleFixture.ALL_EXAMPLE_ARTICLES)

        val articles = articleRepository.search("Flauschig")

        assertThat(articles).hasSize(1)
        assertThat(articles.first().titel).isEqualTo(ArticleFixture.EXAMPLE_ARTICLE_2.titel)

    }


    @Test
    fun `can search and rank`() {
        articleRepository.saveAll(ArticleFixture.ALL_EXAMPLE_ARTICLES)

        val articles = articleRepository.searchTop10("Flauschig")

        assertThat(articles).hasSize(1)
        assertThat(articles.first().titel).isEqualTo(ArticleFixture.EXAMPLE_ARTICLE_2.titel)

    }
}