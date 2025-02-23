package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguagesListItem(
    matcher: Matcher<View>
) : KRecyclerItem<LanguagesListItem>(matcher) {

    val languageLabel = KTextView(matcher) {
        withId(R.id.option_label)
    }
}