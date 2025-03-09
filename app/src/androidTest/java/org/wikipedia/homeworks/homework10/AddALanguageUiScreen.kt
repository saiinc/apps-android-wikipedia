package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object AddALanguageUiScreen: UiScreen<AddALanguageUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val returnButton = UiButton {
        withContentDescription(
            contentDescription = "Navigate up"
        )
    }

    val languageNameRussian = UiTextView {
        withId(
            packageName = this@AddALanguageUiScreen.packageName,
            resourceId = "localized_language_name"
        )
        withText("Русский")
    }
}