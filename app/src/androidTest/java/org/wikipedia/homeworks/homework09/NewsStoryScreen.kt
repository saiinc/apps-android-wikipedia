package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object NewsStoryScreen: KScreen<NewsStoryScreen>() {
    override val layoutId = R.layout.fragment_news
    override val viewClass = null

    val headerImage = KImageView {
        withId(R.id.header_image_view)
    }

    val toolbar = KToolbar {
        withId(R.id.toolbar)
    }

    val storyText = KTextView {
        withId(R.id.story_text_view)
    }

    val newsStoryList = KRecyclerView(
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType(::NewsStoryListItem)
        }
    )
}