package org.wikipedia.homeworks.homework20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.main.MainActivity

class NamedItemsTest: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun namedItemsTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew {
                    isVisible(feed)
                    topReadItem().perform {
                        isVisible(this)
                        isVisible(topReadCardViewList)
                        topReadListItem(1) {
                            isVisible(this)
                            isVisible(cardTitle)
                        }
                    }
                }
            }
        }
    }
}