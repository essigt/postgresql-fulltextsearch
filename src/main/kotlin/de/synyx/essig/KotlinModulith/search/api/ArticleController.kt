package de.synyx.essig.KotlinModulith.search.api

import de.synyx.essig.KotlinModulith.search.repository.Article
import de.synyx.essig.KotlinModulith.search.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime

@Controller
@RequestMapping("/")
class ArticleController(
    @Autowired private val articleRepository: ArticleRepository,
) {
    @GetMapping("")
    fun listArticles(@RequestParam(name = "q") query: String?, model: Model): String {

        val articles =
            if (query.isNullOrEmpty())
                articleRepository.findAll().toList()
            else
                articleRepository.search(query)

        model.addAttribute("q", query)
        model.addAttribute("articles", articles)
        model.addAttribute("newArticle", ArticleDto("", "", ""))

        return "index"
    }

    @PostMapping()
    fun createArticle(@ModelAttribute newArticle: ArticleDto): String {
        articleRepository.save(newArticle.toEntity())

        return "redirect:/"
    }

    @GetMapping("{query}")
    fun searchArticles(@PathVariable("query") query: String): List<Article> =
        articleRepository.findByAuthorLikeOrContentLike("%$query%", "%$query%")

    data class ArticleDto(val titel: String, val content: String, val author: String) {

        fun toEntity() = Article(
            0L,
            ZonedDateTime.now(),
            author,
            titel,
            content
        )
    }
}

