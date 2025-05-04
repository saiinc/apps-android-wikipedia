package org.wikipedia.homeworks.homework26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework22.topReadCardItemByClass
import org.wikipedia.homeworks.homework24.WebViewDSLPO
import org.wikipedia.main.MainActivity

class SmartScenarioTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun skipBannerTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew.topReadCardItemByClass {
                    topReadListItem(1) {
                        click(this)
                    }
                }
                WebViewDSLPO {
                    click(saveButton)
                    click(backButton)
                }
                click(ExploreScreenNew.savedArticles)
                swipeDown()
                click(SavedArticlesScreen.exploreButton)
            }
        }
    }
}