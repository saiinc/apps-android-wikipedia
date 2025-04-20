package org.wikipedia.homeworks.homework22

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.main.MainActivity

class RecyclerIdTest: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun announcementIdTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew.announcementItemById {
                    isVisible(this)
                    isVisible(text)
                    isVisible(headerImage)
                }
                ExploreScreenNew.searchCardItemById {
                    isVisible(this)
                    isVisible(voiceIcon)
                }
                ExploreScreenNew.searchCardItemByClass {
                    isVisible(this)
                    isVisible(voiceIcon)
                }
                ExploreScreenNew.topReadCardItemByClass(0) {
                    isVisible(this)
                    isVisible(headerTitle)

                }
            }
        }
    }

    @Test
    fun topReadIdTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew.topReadCardItemByClass(2) {
                    isVisible(this)
                    isVisible(headerTitle)
                }
            }
        }
    }
}