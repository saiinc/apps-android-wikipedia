package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsStoryListItem(
    matcher: Matcher<View>
) : KRecyclerItem<NewsStoryListItem>(matcher) {

    val title = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val subtitle = KTextView(matcher) {
        withText(R.id.view_list_card_item_subtitle)
    }

    val image = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }
}