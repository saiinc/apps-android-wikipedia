package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebViewTest: TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun lessonWebViewTest() {
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
                this.webView {
                    withElement(
                        locator = Locator.XPATH,
                        value = "//span[@class='mw-page-title-main']",
                        interaction = {
                            hasText("Five pounds (gold coin)")
                        }
                    )
                }
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
}