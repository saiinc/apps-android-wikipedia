package org.wikipedia.homeworks.homework03

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

val imageLogo = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered"
)

val primaryText = listOf(
    AppTextView::class.java,
    "primaryTextView"
)

val secondaryText = listOf(
    AppTextView::class.java,
    "secondaryTextView"
)

val languageOptionEnglish = listOf(
    AppTextView::class.java,
    "option_label"
)

val addLanguageButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val tabPageIndicator = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator"
)