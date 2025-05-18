package org.wikipedia.homeworks.homework29

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework26.SavedArticlesScreen
import org.wikipedia.main.MainActivity

class BuildConfigTest: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun passwordEnterTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                click(ExploreScreenNew.savedArticles)
                click(SavedArticlesScreen.loginJoinWikipedia)
                click(CreateAccountScreen.loginButton)
                LoginScreen {
                    val login = Users.the_saionji
                    authorize(login)
                    sleep(10000)
                }
            }
        }
    }
}