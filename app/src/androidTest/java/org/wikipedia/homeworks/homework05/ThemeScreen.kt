package org.wikipedia.homeworks.homework05

import android.widget.LinearLayout
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val pullDialogView = KView {
    withBackgroundColor(R.drawable.rounded_2dp_fill)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val textSettingsCategory = KTextView {
    withId(R.id.textSettingsCategory)
    withText(R.string.theme_category_reading)
}

val textSizePercent = KTextView {
    withId((R.id.text_size_percent))
}

val buttonDecreaseTextSize = KTextView {
    withId(R.id.buttonDecreaseTextSize)
    withContentDescription(R.string.text_size_decrease)
}

val textSizeSeekBar = KSeekBar {
    withId(R.id.text_size_seek_bar)
}

val buttonIncreaseTextSize = KTextView {
    withId(R.id.buttonIncreaseTextSize)
    withContentDescription(R.string.text_size_increase)
}

val buttonFontFamilySansSerif = KButton {
    withId(R.id.button_font_family_sans_serif)
}

val buttonFontFamilySerif = KButton {
    withId(R.id.button_font_family_serif)
}

val imageReadingFocusMode = KImageView {
    withParent {
        withId(R.id.readingFocusModeContainer)
    }
}

val switchReadingFocusMode = KSwitch {
    withId(R.id.theme_chooser_reading_focus_mode_switch)
}

val descriptionReadingFocusMode = KTextView {
    withId(R.id.theme_chooser_reading_focus_mode_description)
}

val headerThemeSelect = KTextView {
    withText(R.string.color_theme_select)
}

val buttonThemeLight = KButton {
    withId(R.id.button_theme_light)
}

val buttonThemeSepia = KButton {
    withId(R.id.button_theme_sepia)
}

val buttonThemeDark = KButton {
    withId(R.id.button_theme_dark)
}

val buttonThemeBlack = KButton {
    withId(R.id.button_theme_black)
}

val switchMathSystemTheme = KSwitch {
    withId(R.id.theme_chooser_match_system_theme_switch)
}

val switchDimmingImages = KSwitch {
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
}