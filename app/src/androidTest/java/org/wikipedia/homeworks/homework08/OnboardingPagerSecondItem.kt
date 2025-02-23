package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lessons.lesson07.OnboardingPagerFirstItem

class OnboardingPagerSecondItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerFirstItem>(matcher) {
    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val primaryText = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val secondaryText = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }
}