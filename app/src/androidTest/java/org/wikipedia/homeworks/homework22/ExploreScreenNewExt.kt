package org.wikipedia.homeworks.homework22

import android.content.Context
import android.view.View
import org.wikipedia.R
import org.wikipedia.feed.searchbar.SearchCardView
import org.wikipedia.feed.topread.TopReadCardView
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework20.ExploreScreenNew

fun ExploreScreenNew.searchCardItemById(targetIndex: Int = 0, function: SearchCardViewItem.() -> Unit) {
    feed.invokeById(
        targetIndex = targetIndex,
        targetId = R.id.voice_search_button,
        blockName = "Search Card",
        limiter = (4 * targetIndex).coerceAtLeast(5),
        function = function
    )
}

fun ExploreScreenNew.searchCardItemByClass(targetIndex: Int = 0, function: SearchCardViewItem.() -> Unit) {

    feed.invokeByClass(
        targetIndex = targetIndex,
        targetClass = SearchCardView::class.java,
        blockName = "Search Card",
        limiter = (4 * targetIndex).coerceAtLeast(5),
        function = function
    )
}

fun ExploreScreenNew.topReadCardItemByClass(targetIndex: Int = 0, function: TopReadCardViewItem.() -> Unit) {
    feed.invokeByClass(
        targetIndex = targetIndex,
        targetClass = TopReadCardView::class.java,
        blockName = "Top read Card",
        limiter = (14 * targetIndex).coerceAtLeast(5),
        function = function
    )
}