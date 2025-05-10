package org.wikipedia.homeworks.homework27

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.files.attachScreenshotToAllureReport
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.interceptors.testrun.ScreenshotTestInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.device.screenshots.Screenshots
import com.kaspersky.kaspresso.interceptors.watcher.testcase.StepWatcherInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import com.kaspersky.kaspresso.testcases.models.info.TestInfo
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework22.searchCardItemById
import org.wikipedia.main.MainActivity

class InterceptorsTest : TestCase(
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
                        hasText(searchText, "asdfsdf")
                    }
                }
            }
        }
    }
}

class SuccessFinaleScreenshotTestInterceptor(
    private val screenshots: Screenshots
) : TestRunWatcherInterceptor {

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        onSectionFailed(makeTag(testInfo,success))
    }

    private fun onSectionFailed(tag: String) {
        screenshots.takeAndApply(tag) { attachScreenshotToAllureReport() }
    }

    private fun makeTag(testInfo: TestInfo, success: Boolean): String =
        "${testInfo.testName}_${if (success) "success" else "failed"}"
}

class FailOnlyScreenshotStepInterceptor(
    private val screenshots: Screenshots
) : StepWatcherInterceptor {

    override fun interceptAfterWithError(stepInfo: StepInfo, error: Throwable) {
        intercept("${makeTag(stepInfo)}_failure_${error.javaClass.simpleName}")
    }

    private fun intercept(tag: String) {
        screenshots.takeAndApply(tag) { attachScreenshotToAllureReport() }
    }

    private fun makeTag(stepInfo: StepInfo): String = "${stepInfo.testClassName}_step_${stepInfo.ordinal}"
}