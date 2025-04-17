package org.wikipedia.homeworks.homework21

import androidx.test.espresso.assertion.ViewAssertions
import io.github.kakaocup.kakao.common.matchers.DrawableMatcher
import io.github.kakaocup.kakao.image.KImageView

fun KImageView.hasAnyDrawable() {

    //val getDrawable = GetDrawable()
    //view.perform(getDrawable)
    //val drawable = getDrawable.getDrawable()
    //view.check(ViewAssertions.matches(DrawableMatcher(drawable = drawable)))

    view.check(CustomAnyDrawableAssertion())
}

fun KImageView.noDrawable() {
    view.check(CustomNoDrawableAssertion())
}
