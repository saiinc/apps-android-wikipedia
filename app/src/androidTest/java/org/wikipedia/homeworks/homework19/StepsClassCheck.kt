package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class StepsClassCheck: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceNetworkTest() {
        run { 
            steps {
                disableNetwork(device)
                sleep(5000)
                enableNetwork(device)
            }
        }
    }

    @Test
    fun typeText() {
        run {
            steps {
                click(
                    OnboardingScreen.skipButton,
                    name = "Кнопка skip"
                )
                ExploreScreen.feed.childAt<SearchCardViewItem>(0) {
                    click(searchText, "поле поиска")
                }
                isVisible(SearchScreen.searchField, "строка поиска")
                typeText(
                    SearchScreen.searchField.edit,
                    text = "King",
                    name = "строка поиска"
                )
                typeText(
                    SearchScreen.searchEditField,
                    text = "Null",
                    name = "строка поиска"
                )
                hasText(
                    SearchScreen.searchEditField,
                    text = "KingNull",
                    name = "строка поиска",
                )
                containsText(
                    SearchScreen.searchEditField,
                    text = "ingNu",
                    name = "строка поиска"
                )
                hasAnyText(
                    SearchScreen.searchEditField,
                    name = "строка поиска"
                )
            }
        }
    }

    @Test
    fun checkableAction() {
        run {
            steps {
                click(
                    OnboardingScreen.skipButton,
                    name = "Кнопка skip"
                )
                ExploreScreen {
                    click(bottomMenuIconMore, "Иконка нижнего меню More")
                    click(moreMenuSettings, "Настройки из нижнего меню")
                }
                isDisplayed(SettingsScreen.settingsList,"список настроек")
                SettingsScreen.settingsList.childAt<SettingsListItem>(3) {
                    isDisplayed(switchBox, "переключатель")
                    setChecked(switchBox, false, "Показывать превью")
                    isNotChecked(switchBox, "Показывать превью")
                    setChecked(switchBox, true, "Показывать превью")
                    isChecked(switchBox, "Показывать превью")
                }
            }
        }
    }

    @Test
    fun screenOrientationTest() {
        run {
            steps {
                setOrientationLeft(device)
                sleep(5000)
                setOrientationRight(device)
                sleep(5000)
                setOrientationNatural(device)
                sleep(5000)
            }
        }
    }
}