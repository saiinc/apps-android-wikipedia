package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class InTheNewsCardViewListItem(
    matcher: Matcher<View>
) : KRecyclerItem<InTheNewsCardViewListItem>(matcher) {
    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.name(withParent("Картинка новостной карточки"))
    }

    val text by lazy {
        KTextView(matcher) {
            withId(R.id.horizontal_scroll_list_item_text)
        }.name(withParent("Текст новостной карточки"))
    }
}