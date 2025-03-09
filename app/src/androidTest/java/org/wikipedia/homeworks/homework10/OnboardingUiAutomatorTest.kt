package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiAutomatorTest: TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

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
}