package org.wikipedia.homeworks.homework08

import androidx.test.espresso.action.GeneralLocation
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingScreenTests: TestCase() {

    @get:Rule
    val activityTestRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun skipButtonTest() {
        run {
            step("Проверка отображения кнопки 'Skip'") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    fun continueButtonTest() {
        run {
            step("Проверка отображения кнопки 'Continue'") {
                OnboardingScreen.continueButton.isDisplayed()
            }
        }
    }

    @Test
    fun logoTest() {
        run {
            step("Проверка наличия логотипа Википедии") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    image.isDisplayed()
                }
            }
        }
    }

    @Test
    fun addLanguagesButtonTest() {
        run {
            step("Проверка отображения кнопки 'Add or edit Languages'") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    addOrEditLanguagesButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun onboardingPagerSecondItemTest() {
        run {
            step("Проверка текста на втором элементе слайдера") {
                OnboardingScreen.slider.childAt<OnboardingPagerSecondItem>(1) {
                    primaryText.hasText("New ways to explore")
                }
            }
        }
    }

    @Test
    fun englishLanguageTest() {
        run {
            step("Проверка отображения английского языка") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    languages.childWith<LanguagesListItem> {
                        withText("1.\t\tEnglish")
                    }.isDisplayed()
                    /*languages.childAt<LanguagesListItem>(0) {
                        isDisplayed()
                        languageLabel.isVisible()
                        languageLabel.hasText("1.\t\tEnglish")
                    }*/
                }
            }
        }
    }

    @Test
    fun languageScreenTest() {
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
                    languageSubtitle.click()
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
                    languages.childWith<LanguagesListItem> {
                        withText("2.\t\tРусский")
                    }.isDisplayed()
                    /*languages.childAt<LanguagesListItem>(1) {
                        isDisplayed()
                        languageLabel.hasText("2.\t\tРусский")
                    }*/
                }
            }
        }
    }
}