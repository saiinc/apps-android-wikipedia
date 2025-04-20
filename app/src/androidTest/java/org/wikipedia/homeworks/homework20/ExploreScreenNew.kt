package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.InTheNewsCardViewItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework22.invokeById

object ExploreScreenNew: NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Главный экран"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle: KImageView by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.name(withParent("Заголовок"))
    }

    val feed by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::SearchCardViewItem)
                itemType(::AnnouncementCardViewItem)
                itemType(::DayHeaderCardViewItem)
                itemType(::FeaturedArticleItem)
                itemType(::TopReadCardViewItem)
                itemType(::InTheNewsCardViewItem)
            }
        ).name(withParent("Список блоков"))
    }

    val bottomMenuIconMore = KView {
        withId(R.id.nav_tab_more)
    }

    val moreMenuSettings = KView {
        withId(R.id.main_drawer_settings_container)
    }

    fun announcementItemById(targetIndex: Int = 0, function: AnnouncementCardViewItem.() -> Unit) {
        feed.invokeById(
            targetIndex = targetIndex,
            targetId = R.id.view_announcement_text,
            blockName = "Announcement Card",
            limiter = (4 * targetIndex).coerceAtLeast(5),
            function = function
        )
    }

    fun topReadItem(index: Int, function: TopReadCardViewItem.() -> Unit) {
        feed.invokeAtIndex(index, function)
    }

    fun topReadItem(): TopReadCardViewItem {
        return feed.childWith<TopReadCardViewItem> {
            withDescendant {
                withText("Top read")
            }
        }.name(feed.getName().withParent("Top read"))
    }

    fun inTheNewsItem(index: Int, function: InTheNewsCardViewItem.() -> Unit) {
        feed.invokeAtIndex(index, function)
    }

    fun inTheNewsItem(): InTheNewsCardViewItem {
        return feed.childWith<InTheNewsCardViewItem> {
            withDescendant {
                withText("In the news")
            }
        }.name(feed.getName().withParent("In the news"))
    }
}
