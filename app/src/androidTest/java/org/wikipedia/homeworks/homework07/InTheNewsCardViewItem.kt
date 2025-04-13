package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.ExploreScreenNew.feed
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class InTheNewsCardViewItem(
    matcher: Matcher<View>
) : KRecyclerItem<InTheNewsCardViewItem>(matcher) {
    val headerTitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val inTheNewsItem = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::InTheNewsCardViewListItem)
        }
    )

    fun inTheNewsListItem(index: Int, function: InTheNewsCardViewListItem.() -> Unit) {
        inTheNewsItem.invokeAtIndex(index, function)
    }
}