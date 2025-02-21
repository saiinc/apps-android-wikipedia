package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadCardViewListItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardViewListItem>(matcher) {
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

    val cardTitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val cardSubtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
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