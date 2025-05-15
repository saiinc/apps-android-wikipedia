package org.wikipedia.homeworks.homework28

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.AllureId
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework22.searchCardItemById
import org.wikipedia.main.MainActivity

class RuleTest: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val happyTestRule = HappyTestRule(testLogger)

    @get:Rule
    val  allureHappyRule = AllureHappyRule(testLogger)

    @get:Rule
    val deprecatedTestRule = DeprecatedTestRule()

    @Test
    @AllureId("123")
    fun ruleTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew {
                    searchCardItemById {
                        isVisible(this)
                        isVisible(searchText)
                        hasText(searchText, "Search Wikipedia")
                    }
                }
            }
        }
    }
    @Test
    @Deprecated("deprecated", ReplaceWith("run { actual }"))
    fun deprecatedTest() {
        run {  }
    }
}