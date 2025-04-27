package org.wikipedia.homeworks.homework24;

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
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
@get:Rule
val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWebView() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew.topReadCardItemByClass {
                    topReadListItem(1) {
                        click(this)
                    }
                }
                WebViewDSLPO {
                    scroll(referencesHeader)
                    hasText(referencesHeader, "References")
                    click(referencesHeader)
                    getReferencesList(1) {
                        containsText(content, "Demeyer, Tess")
                    }
                    getReferencesList(2) {
                        containsText(content, "Kaufman, Michelle")
                    }
                }
            }
        }
    }
}
