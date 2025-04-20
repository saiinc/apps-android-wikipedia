
package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class SearchCardViewItem(matcher: Matcher<View>) : KRecyclerItem<SearchCardViewItem>(matcher) {
    val searchIcon by lazy {
        KImageView(matcher) {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.name(withParent("Иконка поиска"))
    }

    val searchText by lazy {
        KEditText(matcher) {
            withText(R.string.search_hint)
        }.name(withParent("Текст"))
    }

    val voiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Иконка микрофона"))
    }
}