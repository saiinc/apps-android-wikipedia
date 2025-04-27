package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.homeworks.homework24.KWebViewBaseElement
import org.wikipedia.homeworks.homework24.KWebViewElement

class NamedSteps(val testContext: TestContext<*>) {
    private fun execute(textOfStep: String, actions: (StepInfo) -> Unit){
        testContext.step(textOfStep, actions)
    }

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
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