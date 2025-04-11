package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object SearchScreen: KScreen<SearchScreen>() {
    override val layoutId = null
    override val viewClass = null

    val searchToolbar = KToolbar {
        withId(R.id.search_toolbar)
    }

    val searchField = KTextInputLayout {
        withId(R.id.search_cab_view)
    }

    val searchEditField = KEditText {
        withId(androidx.appcompat.R.id.search_src_text)
    }
}