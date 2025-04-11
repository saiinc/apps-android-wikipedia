package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object SettingsScreen : KScreen<SettingsScreen>(){
    override val layoutId = null
    override val viewClass = null

    val settingsList = KRecyclerView(
        builder = {
            withId(R.id.recycler_view)
        },
        itemTypeBuilder = {
            itemType(::SettingsListItem)
        }
    )
}