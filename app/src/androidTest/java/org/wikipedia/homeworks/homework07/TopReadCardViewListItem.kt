package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class TopReadCardViewListItem(matcher: Matcher<View>): KRecyclerItem<TopReadCardViewListItem>(matcher) {
    val cardBaseNumberView = KTextView(matcher) {
        withId(R.id.baseNumberView)
    }

    val cardNumberCircle = KTextView(matcher) {
        withDrawable(R.drawable.shape_circle)
        withParent {
            withId(R.id.view_list_card_number)
        }
    }

    val cardNumberText = KTextView(matcher) {
        withId(R.id.numberView)
    }

    val cardTitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Заголовок статьи"))
    }

    val cardSubtitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Описание"))
    }

    val cardGraph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val cardPageviews = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }

    val cardImage = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }
}