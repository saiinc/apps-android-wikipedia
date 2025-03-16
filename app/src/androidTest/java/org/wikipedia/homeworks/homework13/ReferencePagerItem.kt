package org.wikipedia.homeworks.homework13

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ReferencePagerItem(
    matcher: Matcher<View>
) : KViewPagerItem<ReferencePagerItem>(matcher) {
    val id = KTextView(matcher) {
        withId(R.id.reference_id)
    }

    val text = KTextView(matcher) {
        withId(R.id.reference_text)
    }
}