package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val image = UiView {
        withId(
            packageName = this@OnboardingUiScreen.packageName,
            resourceId = "imageViewCentered"
        )
    }

    val primaryText = UiTextView {
        withId(
            packageName = this@OnboardingUiScreen.packageName,
            resourceId = "primaryTextView"
        )
    }

    val secondaryText = UiTextView {
        withId(
            packageName = this@OnboardingUiScreen.packageName,
            resourceId = "secondaryTextView"
        )
    }

    val addOrEditLanguagesButton = UiButton {
        withId(
            packageName = this@OnboardingUiScreen.packageName,
            resourceId = "addLanguageButton"
        )
    }

    val languageList = UiView {
        withId(this@OnboardingUiScreen.packageName, "languageListContainer")
    }

    val installedLanguage = UiTextView {
        withIndex(1) {
            withId(
                packageName = this@OnboardingUiScreen.packageName,
                resourceId = "option_label"
            )
        }
    }

    val continueButton = UiButton {
        withId(
            packageName = this@OnboardingUiScreen.packageName,
            resourceId = "fragment_onboarding_forward_button"
        )
    }

    val skipButton = UiButton {
        withId(
            packageName = this@OnboardingUiScreen.packageName,
            resourceId = "fragment_onboarding_skip_button"
        )
    }

    val pageIndicator = UiScrollView {
        withId(
            packageName = this@OnboardingUiScreen.packageName,
            resourceId = "view_onboarding_page_indicator"
        )
    }
}