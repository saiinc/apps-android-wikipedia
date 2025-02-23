package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object WikipediaLanguagesScreen : KScreen<WikipediaLanguagesScreen>() {
    override val layoutId = R.layout.activity_single_fragment
    override val viewClass = null

    val languagesToolbar = KToolbar {
        withId(R.id.toolbar)
    }

    val wikipediaLanguagesList = KRecyclerView(
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        },
        itemTypeBuilder = {
            itemType(::WikipediaLanguagesListItem)
        }
    )

    val addLanguageButton = KTextView {
        withId(R.id.wiki_language_title)
        withText(R.string.wikipedia_languages_add_language_text)
    }
}