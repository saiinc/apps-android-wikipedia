package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItem>(matcher) {
    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val articleTitle = KTextView(matcher) {
        withId(R.id.articleTitle)
    }
}