package org.wikipedia.homeworks.homework22

import android.view.View
import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.hasIdAction(targetId: Int): Boolean {
    val checker = HasIdAction(targetId)
    view.perform(checker)
    return checker.getResult()
}

fun BaseActions.hasClassAction(targetClass: Class<out View>): Boolean {
    val checker = HasClassAction(targetClass)
    view.perform(checker)
    return checker.getResult()
}