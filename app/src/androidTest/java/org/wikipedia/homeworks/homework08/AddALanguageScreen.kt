package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object AddALanguageScreen : KScreen<AddALanguageScreen>() {
    override val layoutId = R.layout.activity_single_fragment
    override val viewClass = null

    val languagesList = KRecyclerView(
        builder = {
            withId(R.id.languages_list_recycler)
        },
        itemTypeBuilder = {
            itemType(::AddALanguageListItem)
        }
    )
}