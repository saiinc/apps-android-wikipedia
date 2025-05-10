package org.wikipedia.homeworks.homework27

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework22.searchCardItemById
import org.wikipedia.main.MainActivity

class NormalTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
        stepWatcherInterceptors.add(FailOnlyScreenshotStepInterceptor(screenshots))
        testRunWatcherInterceptors.add(SuccessFinaleScreenshotTestInterceptor(screenshots))
    }) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun customAllureScreenshotTest() {
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
}