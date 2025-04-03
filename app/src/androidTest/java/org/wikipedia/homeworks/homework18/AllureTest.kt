package org.wikipedia.homeworks.homework18

import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardViewItem
import org.wikipedia.homeworks.homework07.InTheNewsCardViewListItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework08.AddALanguageListItem
import org.wikipedia.homeworks.homework08.AddALanguageScreen
import org.wikipedia.homeworks.homework08.LanguagesListItem
import org.wikipedia.homeworks.homework08.OnboardingPagerFirstItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework08.WikipediaLanguagesListItem
import org.wikipedia.homeworks.homework08.WikipediaLanguagesScreen
import org.wikipedia.homeworks.homework09.NewsStoryListItem
import org.wikipedia.homeworks.homework09.NewsStoryScreen
import org.wikipedia.homeworks.homework09.WikiArticleScreen
import org.wikipedia.homeworks.homework10.AddALanguageUiScreen
import org.wikipedia.homeworks.homework10.OnboardingUiScreen
import org.wikipedia.homeworks.homework10.WikipediaLanguagesUiScreen
import org.wikipedia.homeworks.homework11.ArticleUiScreen
import org.wikipedia.homeworks.homework11.ExploreUiScreen
import org.wikipedia.homeworks.homework11.NetworkErrorScreen
import org.wikipedia.homeworks.homework13.ArticleRedirectPreviewScreen
import org.wikipedia.homeworks.homework13.ArticleReferenceScreen
import org.wikipedia.homeworks.homework13.ArticleViewScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class AllureTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun inTheNewsTest() {
        run {
            step("Скипаем онбординг") {
                OnboardingScreen.skipButton.click()
            }
            step("Скроллим до блока 'In the news' (по тексту заголовка)") {
                ExploreScreen.feed.childWith<InTheNewsCardViewItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    step("Листаем до третьей картинки и кликаем по ней") {
                        inTheNewsItem.childAt<InTheNewsCardViewListItem>(0) {
                            image.click()
                        }
                    }
                }
            }
            step("Кликаем по второй статье из списка") {
                NewsStoryScreen.newsStoryList.childAt<NewsStoryListItem>(1) {
                    title.click()
                }
            }
            step("Проверяем, что отображается элемент с ID page_web_view") {
                WikiArticleScreen.pageWeb.isDisplayed()
            }
        }
    }

    @Test
    fun homeworkWebViewTest() {
        run {
            OnboardingScreen.skipButton.click()
            ExploreScreen.feed.childWith<SearchCardViewItem> {
                withDescendant {
                    withText("Featured article")
                }
            }.perform {
                click()
            }
            ArticleViewScreen {
                webView {
                    withElement(
                        locator = Locator.XPATH,
                        value = "//h2[@id='References']",
                        interaction = {
                            scroll()
                        }
                    )

                    withElement(
                        locator = Locator.XPATH,
                        value = "//h2[@id='References']",
                        interaction = {
                            hasText("References")
                        }
                    )

                    withElement(
                        locator = Locator.XPATH,
                        value = "//a[@style='counter-reset: mw-Ref 5;']",
                        interaction = {
                            click()
                        }
                    )
                }
            }
            step("Во всплывающем окне (вторая картинка) проверить на соответствие текст заголовка") {
                ArticleReferenceScreen.title.hasText("Reference ")
            }
            step("и номер в строке (5.)") {
                ArticleReferenceScreen {
                    id.hasText("5.")
                }
            }
            ArticleReferenceScreen.pager.scrollToStart()
            device.uiDevice.pressBack()
            step("Найти вторую ссылку с CSS классом mw-redirect и нажать на неё") {
                ArticleViewScreen {
                    webView {
                        withElement(
                            locator = Locator.XPATH,
                            value = "(//a[@class='mw-redirect'])[1]",
                            interaction = {
                                click()
                            }
                        )
                    }
                }
            }
            ArticleRedirectPreviewScreen.readArticleButton.click()
            ArticleViewScreen {
                webView {
                    withElement(
                        locator = Locator.XPATH,
                        value = "//h2[@id='References']",
                        interaction = {
                            scroll()
                        }
                    )
                }
            }
        }
    }

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

    @Test
    fun textInFirstPage() {
        run {
            step("Первый сценарий") {
                OnboardingUiScreen.primaryText.hasText(
                    "The Free Encyclopedia\n" +
                            "…in over 300 languages"
                )
            }
        }
    }

    @Test
    fun textInSecondPage() {
        run {
            step("Второй сценарий") {
                OnboardingUiScreen.continueButton.click()
                OnboardingUiScreen.secondaryText.containsText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed.")
            }
        }
    }

    @Test
    fun textInThirdPage() {
        run {
            step("Третий сценарий") {
                OnboardingUiScreen.continueButton.click()
                OnboardingUiScreen.continueButton.click()
                OnboardingUiScreen.secondaryText.containsText("You can make reading lists from articles you want to read later, even when you’re offline.")
            }
        }
    }

    @Test
    fun textInFourthPage() {
        run {
            step("Четвертый сценарий") {
                OnboardingUiScreen.addOrEditLanguagesButton.click()
                step("Проверка yналичия английского языка") {
                    WikipediaLanguagesUiScreen.languageTitleEnglish.containsText("English")
                }
            }
        }
    }

    @Test
    fun addLanguageTest() {
        run("Сценарий добавления языка") {
            step("Нажатие на кнопку добавления или редактирования языка") {
                OnboardingUiScreen.addOrEditLanguagesButton.click()
            }
            step("Нажатие на кнопку добавления языка") {
                WikipediaLanguagesUiScreen.addLanguageButton.click()
            }
            step("Выбор русского языка") {
                AddALanguageUiScreen.languageNameRussian.click()
            }
            step("Проверка добавленного русского языка") {
                WikipediaLanguagesUiScreen.languageTitleRussian.containsText("Русский")
            }
            step("Возврат в экран Onboarding") {
                WikipediaLanguagesUiScreen.returnButton.click()
            }
            step("Проверка отображения русского языка") {
                OnboardingUiScreen.installedLanguage.containsText("2.\t\tРусский")
            }
        }
    }

    @Test
    fun languageAddTest() {
        run {
            step("Нажатие на кнопку добавления или редактирования языка") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    addOrEditLanguagesButton.click()
                }
            }
            step("Нажатие на кнопку добавления языка") {
                WikipediaLanguagesScreen.addLanguageButton.click()
            }
            step("Выбор русского языка") {
                AddALanguageScreen.languagesList.childAt<AddALanguageListItem>(2) {
                    languageName.isDisplayed()
                    languageName.click()
                    //languageSubtitle.isDisplayed()
                    //languageSubtitle.click()
                }
            }
            step("Проверка добавленного русского языка") {
                WikipediaLanguagesScreen.wikipediaLanguagesList.childAt<WikipediaLanguagesListItem>(2) {
                    wikiLanguageTitle.hasText("Русский")
                }
            }
            step("Возврат в экран Onboarding") {
                WikipediaLanguagesScreen.languagesToolbar.click(GeneralLocation.CENTER_LEFT)
            }
            step("Проверка отображения русского языка") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    languages.childAt<LanguagesListItem>(1) {
                        hasText("2.\t\tРусский")
                    }
                }
            }
        }
    }
}