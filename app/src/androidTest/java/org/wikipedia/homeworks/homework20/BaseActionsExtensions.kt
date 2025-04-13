package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions

private val names = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    names[this] = nameHierarchy
    return this
}

fun BaseActions.getName(): NameHierarchy  {
    return names[this] ?: throw RuntimeException("Укажи имя")
}

fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)