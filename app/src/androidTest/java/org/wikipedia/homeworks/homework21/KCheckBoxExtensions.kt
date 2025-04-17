package org.wikipedia.homeworks.homework21

import io.github.kakaocup.kakao.check.KCheckBox


fun KCheckBox.switch() {
    val getCheckBoxState = GetCheckBoxState()
    view.perform(getCheckBoxState)
    val state = getCheckBoxState.getState()
    perform {
        setChecked(!state)
    }
}