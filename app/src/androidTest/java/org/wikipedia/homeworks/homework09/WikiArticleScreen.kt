package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KProgressBar
import io.github.kakaocup.kakao.scroll.KScrollView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object WikiArticleScreen: KScreen<WikiArticleScreen>() {
    override val layoutId = R.layout.activity_page
    override val viewClass = null

    val pageWeb = KView {
        withId(R.id.page_web_view)
    }

    val pageActionsTab = KTabLayout {
        withId(R.id.page_actions_tab_layout)
    }

    val pageProgressBar = KProgressBar {
        withId(R.id.page_progress_bar)
    }

    val pageToolbar = KToolbar {
        withId(R.id.page_toolbar)
    }
    val pageToolbarSearch = KTextView {
        withId(R.id.page_toolbar_button_search)
    }

    val tabsCountText = KTextView {
        withId(R.id.tabsCountText)
    }

    val pageToolbarMenu = KImageView {
        withId(R.id.page_toolbar_button_show_overflow_menu)
    }

    val articleImage = KImageView {
        withId(R.id.articleImage)
    }

    val articleTitle = KTextView {
        withId(R.id.articleTitle)
    }

    val articleDescription = KTextView {
        withId(R.id.articleDescription)
    }

    val pageScroller = KScrollView {
        withId(R.id.page_scroller_button)
    }
}