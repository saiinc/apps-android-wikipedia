package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.builders.UiViewBuilder
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object WikipediaLanguagesUiScreen: UiScreen<WikipediaLanguagesUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val returnButton = UiButton {
        withContentDescription(
            contentDescription = "Navigate up"
        )
    }

    val languageTitleEnglish = UiTextView {
        withId(
            packageName = this@WikipediaLanguagesUiScreen.packageName,
            resourceId = "wiki_language_title"
        )
        withText("English")
    }

    val languageTitleRussian = UiTextView {
        withId(
            packageName = this@WikipediaLanguagesUiScreen.packageName,
            resourceId = "wiki_language_title"
        )
        withText("Русский")
    }

    val addLanguageButton = UiTextView {
        withId(
            packageName = this@WikipediaLanguagesUiScreen.packageName,
            resourceId = "wiki_language_title"
        )
        withText("Add language")
    }
}