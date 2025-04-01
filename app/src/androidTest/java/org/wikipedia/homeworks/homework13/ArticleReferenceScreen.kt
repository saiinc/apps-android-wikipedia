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

    // В общем, когда нужно описать видимый элемент пейджера можно использовать такие матчеры:
    val id = KTextView {
        withId(R.id.reference_id)
        isDisplayed()
    }
    /* не описывая сам пейджер и его блоки
В этом случае будет ссылаться на видимый элемент с соответствующим ID.
Не должно получиться так, что у пейджера видно сразу несколько слайдов
     */


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