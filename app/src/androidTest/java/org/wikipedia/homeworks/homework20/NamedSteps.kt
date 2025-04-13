package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions

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

    fun isVisible(element: BaseAssertions) {
        execute("Проверяем наличие элемента '${(element as BaseActions).getName()}'") {
            element.isVisible()
        }
    }

    fun isDisplayed(element: BaseAssertions, elementDesc: String) =
        execute("${(element as BaseActions).getName()} отображается") { element.isDisplayed() }
}