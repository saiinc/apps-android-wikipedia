package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.lessons.lesson07.OnboardingScreen

object OnboardingScreen : NamedKScreen<OnboardingScreen>() {
    override val screenName = "Экран онбординга"
    override val layoutId = null
    override val viewClass = null

    val skipButton: KButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.name(withParent("Кнопка skip"))
    }

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPagerFirstItem)
            itemType(::OnboardingPagerSecondItem)
        }
    )

    val pageIndicator = KTabLayout {
        withId(R.id.view_onboarding_page_indicator)
    }
}