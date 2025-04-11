package org.wikipedia.homeworks.homework07

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreen: KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val feed = KRecyclerView(
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
    )

    val bottomMenuIconMore = KView {
        withId(R.id.nav_tab_more)
    }

    val moreMenuSettings = KView {
        withId(R.id.main_drawer_settings_container)
    }
}
