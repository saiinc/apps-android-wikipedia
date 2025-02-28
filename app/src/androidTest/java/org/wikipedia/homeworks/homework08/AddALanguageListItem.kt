package org.wikipedia.homeworks.homework08

import android.view.View
import android.widget.LinearLayout
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AddALanguageListItem(
    matcher: Matcher<View>
) : KRecyclerItem<AddALanguageListItem>(matcher) {

    val languageName = KTextView(matcher) {
        withId(R.id.localized_language_name)
    }

    val languageSubtitle = KTextView(matcher) {
        withId(R.id.language_subtitle)
        withParent {
            isInstanceOf(LinearLayout::class.java)
        }
    }
}