package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework10.OnboardingUiScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class DeviceTest: TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceTest() {
        before {
            device.network.disable()
        }.after {
            device.network.enable()
            device.language.switchInApp(Locale.ENGLISH)
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        }.run {
            Thread.sleep(3000)
            device.uiDevice.findObject(UiSelector().text("").index(1)).isEnabled
            device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
            device.language.switchInApp(Locale.FRANCE)
            adbServer.performAdb()
        }
    }

    @Test
    fun screenRotateTest() {
        before {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        }.after {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        }.run {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
            step("проверка ориентации") {
                device.uiDevice.isNaturalOrientation
            }
        }
    }

    @Test
    fun screenOffOnTest() {
        run {
            device.uiDevice.sleep()
            device.uiDevice.wakeUp()
            OnboardingUiScreen.continueButton.isEnabled()
        }
    }

    @Test
    fun collapseRestoreApp() {
        run {
            device.uiDevice.pressHome()
            device.uiDevice.pressRecentApps()
            device.uiDevice.pressRecentApps()
            OnboardingUiScreen.primaryText.isEnabled()
        }
    }

    @Test
    fun networkDisableTest() {
        before {

        }.after {
            device.network.enable()
        }.
        run {
            OnboardingUiScreen.skipButton.click()
            Thread.sleep(3000)
            device.network.disable()
            Thread.sleep(3000)
            ExploreUiScreen.featured_article.click()
            Thread.sleep(5000)
            device.network.enable()
            NetworkErrorScreen.retryButton.click()
            Thread.sleep(3000)
            ArticleUiScreen.articleImage.isEnabled()
        }
    }

    @Test
    fun languageCheckTest() {
        before {

        }.after {
            device.language.switchInApp(Locale.ENGLISH)
        }.
        run {
            device.language.switchInApp(Locale.CHINA)
            Thread.sleep(3000)
            OnboardingUiScreen.skipButton.hasText("跳过")
            device.uiDevice.findObject(UiSelector().text("跳过")).isEnabled
        }
    }

    @Test
    fun mainActivityCheck() {
        run {
            OnboardingUiScreen.skipButton.click()
            Thread.sleep(3000)
            device.activities.isCurrent(MainActivity::class.java)
        }
    }

    @Test
    fun screenshotTest() {
        run {
            device.screenshots.take("homework_test")
            adbServer.performAdb(
                "pull",
                listOf(
                    "/storage/emulated/0/Documents/screenshots/org.wikipedia.homeworks.homework11.DeviceTest/screenshotTest/homework_test.png",
                    "./app/build"
                )
            )
        }
    }
}