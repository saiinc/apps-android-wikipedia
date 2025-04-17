package org.wikipedia.homeworks.homework21

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardViewListItem
import org.wikipedia.homeworks.homework08.OnboardingPagerFirstItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.NewsStoryListItem
import org.wikipedia.homeworks.homework09.NewsStoryScreen
import org.wikipedia.homeworks.homework19.SettingsListItem
import org.wikipedia.homeworks.homework19.SettingsScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework19.steps
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.main.MainActivity

class Test1: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun customActionTest() {
        run {
            namedSteps {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    image.isDisplayed()
                    image.hasAnyDrawable()
                    //image.noDrawable()
                }
                val text = OnboardingScreen.skipButton.getText()
                OnboardingScreen.skipButton.customCheckText("Skip")
                OnboardingScreen.skipButton.customClick()
                ExploreScreenNew.inTheNewsItem().perform {
                    inTheNewsItem.childAt<InTheNewsCardViewListItem>(2) {
                        click()
                    }
                }
                NewsStoryScreen.newsStoryList.childAt<NewsStoryListItem>(2) {
                    image.noDrawable()
                    //image.hasAnyDrawable()
                }
            }
        }
    }

    @Test
    fun checkableAction() {
        run {
            steps {
                click(
                    OnboardingScreen.skipButton,
                    name = "Кнопка skip"
                )
                ExploreScreen {
                    click(bottomMenuIconMore, "Иконка нижнего меню More")
                    click(moreMenuSettings, "Настройки из нижнего меню")
                }
                isDisplayed(SettingsScreen.settingsList,"список настроек")
                SettingsScreen.settingsList.childAt<SettingsListItem>(3) {
                    switchBox {
                        switch()
                        switch()
                        switch()
                        switch()
                        switch()
                        switch()
                        switch()
                        switch()
                        switch()
                        switch()
                        switch()
                        switch()
                    }
                }
            }
        }
    }
}