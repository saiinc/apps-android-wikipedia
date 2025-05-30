package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.wikipedia.homeworks.homework24.KWebViewElement
import org.wikipedia.homeworks.homework26.CloseCustomizeYourToolbarSmartScenario
import org.wikipedia.homeworks.homework26.CloseSyncReadingsListSmartScenario
import org.wikipedia.homeworks.homework26.ListOfSmartScenario
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.homeworks.homework29.Credentials
import org.wikipedia.homeworks.homework29.LoginScreen

class NamedSteps(private val testContext: TestContext<*>) {
    private val listOfSmartScenario = ListOfSmartScenario(
        listOf(
            CloseCustomizeYourToolbarSmartScenario(testContext),
            CloseSyncReadingsListSmartScenario(testContext),
        )
    )
    private fun execute(textOfStep: String, actions: (StepInfo) -> Unit){
        try {
            testContext.step(textOfStep, actions)
        } catch (e: Throwable) {
            if (listOfSmartScenario.execute()) {
                testContext.step(textOfStep, actions)
            } else throw e
        }
    }

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }

    fun authorize(user: String) {
        execute("Авторизоваться") {
            val password = Credentials.getPassword(user)
            LoginScreen.loginField.typeText(user)
            LoginScreen.passwordField.typeText(password)
            Thread.sleep(1000)
            LoginScreen.loginButton.click()
        }

    }

    fun sleep(millis: Long) {
        execute("Сделать паузу в $millis ms") {
            Thread.sleep(millis)
        }
    }

    fun click(element: BaseActions) {
        execute("Нажимаем на элемент '${element.getName()}'") {
            element.click()
        }
    }

    fun click(item: KWebViewElement) {
        execute("Кликаем на веб-элемент '${item.getName()}'") {
            testContext.flakySafely(15000) {
                item.executeAction { click() }
            }
        }
    }

    fun isVisible(element: BaseAssertions) {
        execute("Проверяем наличие элемента '${(element as BaseActions).getName()}'") {
            element.isVisible()
        }
    }

    fun isDisplayed(element: BaseAssertions, elementDesc: String) =
        execute("${(element as BaseActions).getName()} отображается") { element.isDisplayed() }

    fun scroll(element: KWebViewElement) {
        execute("Scroll '${element.getName()}'") {
            testContext.flakySafely(
                timeoutMs = 150000
            ) {
                element.executeAction { scroll() }
            }
        }
    }

    fun swipeDown() {
        execute("Делаем свайп вниз") {
            testContext.device.uiDevice.swipe(500, 500, 500, 900, 20)

        }
    }

    fun hasText(element: TextViewAssertions, text: String) {
        execute("Проверяем у элемента '${(element as BaseActions).getName()}' наличие текста '$text'") {
            element.hasText(text)
        }
    }

    fun hasText(item: KWebViewElement, text: String) {
        execute("Проверяем у веб-элемента '${item.getName()}' наличие текста '$text'") {
            item.executeAction { hasText(text) }
        }
    }

    fun containsText(item: KWebViewElement, text: String) {
        execute("Проверяем, что веб-элемент '${item.getName()}' содержит текст '$text'") {
            item.executeAction { containsText(text) }
        }
    }
}