package org.wikipedia.homeworks.homework19

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R

class SettingsListItem(matcher: Matcher<View>) : KRecyclerItem<SettingsListItem>(matcher) {
    val switchBox = KCheckBox(matcher) {
        withId(R.id.switchWidget)
    }
}