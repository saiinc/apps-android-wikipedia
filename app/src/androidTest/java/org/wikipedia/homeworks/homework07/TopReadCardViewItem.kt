package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class TopReadCardViewItem(matcher: Matcher<View>): KRecyclerItem<TopReadCardViewItem>(matcher) {
    val headerTitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val headerMenu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Меню"))
    }

    val topReadCardViewList by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadCardViewListItem)
            }
        ).name(withParent("Список top read статей"))
    }

    fun topReadListItem(index: Int, function: TopReadCardViewListItem.() -> Unit) {
        topReadCardViewList.invokeAtIndex(index, function)
    }

    val footerMoreTopRead by lazy {
        KTextView(matcher) {
            withId(R.id.footerActionButton)
        }.name(withParent("More"))
    }
}