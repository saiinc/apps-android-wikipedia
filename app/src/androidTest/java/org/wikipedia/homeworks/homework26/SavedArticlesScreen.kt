package org.wikipedia.homeworks.homework26

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.name

object SavedArticlesScreen: NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Экран сохраненных статей"
    override val layoutId = null
    override val viewClass = null

    val exploreButton by lazy {
        KTextView {
            withId(R.id.nav_tab_explore)
        }.name(withParent("Эксплорер"))
    }
}