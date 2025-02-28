package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardViewItem
import org.wikipedia.homeworks.homework07.InTheNewsCardViewListItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class InTheNewsTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun complexTest() {
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
                        inTheNewsItem.childAt<InTheNewsCardViewListItem>(2) {
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
}