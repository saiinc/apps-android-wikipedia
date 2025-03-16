package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R


object ArticleReferenceScreen : KScreen<ArticleReferenceScreen>() {
    override val layoutId = null
    override val viewClass = null

    val title = KTextView {
        withId(R.id.reference_title_text)
    }

    val pager = KViewPager2(
        builder = {
            withId(R.id.reference_pager)
        },
        itemTypeBuilder = {
            itemType(::ReferencePagerItem)
        }
    )

    val tabIndicator = KTabLayout {
        withId(R.id.page_indicator_view)
    }
}