package de.synyx.essig.KotlinModulith.orders.persistence

import de.synyx.essig.KotlinModulith.search.repository.Article
import java.time.ZonedDateTime

object ArticleFixture {


    val EXAMPLE_TIMESTAMP = ZonedDateTime.parse("2024-09-27T12:00:00+01:00")

    val EXAMPLE_ARTICLE_1 = Article(
        0L,
        EXAMPLE_TIMESTAMP,
        "Tim Essig",
        "Volltextsuche mit PostgreSQL und Spring (Teil I)",
        "„Postgres till we see what breaks“ ist ein Ansatz für viele Probleme in der modernen Softwareentwicklung. Eines davon ist die Volltextsuche, denn auch hier bietet PostgreSQL, seit Version 12, von Haus aus nützliche Funktionen. Viel Text über Datenbanken, relationale Integrität, Spalten, Tabellen und anderes Datenbankzeug..."
    )

    val EXAMPLE_ARTICLE_2 = Article(
        0L,
        EXAMPLE_TIMESTAMP,
        "Daniela Grammlich",
        "Flauschig zu Open-Source beitragen",
        "'Wir hatten Nextcloud vor einigen Jahren eingeführt. Die Gründe dafür sind vielfältig und einen eigenen Blogartikel wert. Für diesen ist wichtig: Wir wollen Open-Source leben! Dazu gehört nicht nur, aktiv Open-Source zu nutzen, sondern auch, der Open-Source-Community aktiv etwas zurückzugeben. Issues, Code, Geld, alles was hilft. Also lösten wir unsere langjährige “Testphase” mit Google durch Nextcloud ab und sprangen kopfüber ins Abenteuer..."
    )

    val EXAMPLE_ARTICLE_3 = Article(
        0L,
        EXAMPLE_TIMESTAMP,
        "Jennifer Abel",
        "Kekse im synyx-Design",
        "Manchmal fragen mich Freunde, was ich an IT so toll fände. Für mich ist das die Interdisziplinarität das Faches, denn IT-Themen spielen heute in fast allen Bereichen eine Rolle oder können diese spielen. So möchte ich in diesem Blogartikel mein Hobby Backen und das IT-Thema 3D-Druck verbinden. Ich zeige euch, wie man mit Hilfe von FreeCAD individuelle Ausstechformen für Kekse und Plätzchen zeichnen und mit Hilfe eines 3D-Druckers erstellen kann..."
    )

    val ALL_EXAMPLE_ARTICLES = listOf(EXAMPLE_ARTICLE_1, EXAMPLE_ARTICLE_2, EXAMPLE_ARTICLE_3)
}