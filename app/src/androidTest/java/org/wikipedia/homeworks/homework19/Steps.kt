package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.homeworks.homework24.KWebViewElement

class Steps(val testContext: TestContext<*>) {

    private fun execute(textOfStep: String, actions: (StepInfo) -> Unit){
        testContext.step(textOfStep, actions)
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }

    fun click(item: BaseActions, name: String) {
        execute("Нажимаем на элемент '$name'") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions, name: String) {
        execute("Проверяем наличие элемента '$name'") {
            item.isVisible()
        }
    }

    fun sleep(millis: Long) {
        execute("Сделать паузу в $millis ms") {
            Thread.sleep(millis)
        }
    }

    fun disableNetwork() {
        execute("Отключить сеть") {
            testContext.device.network.disable()
        }
    }

    fun enableNetwork() {
        execute("Включить сеть") {
            testContext.device.network.enable()
        }
    }

    fun typeText(item: EditableActions, text: String, name: String) {
        execute("Ввести текст '$text' в '$name'") {
            item.typeText(text)
        }
    }

    fun setChecked(item: CheckableActions, state: Boolean, name: String) {
        execute("Установить $state для '$name'") {
            item.setChecked(state)
        }
    }

    fun setOrientationLeft() {
        execute("Повернуть дисплей влево") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight() {
        execute("Повернуть дисплей вправо") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural() {
        execute("Повернуть дисплей в естественную позицию") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun hasText(item: TextViewAssertions, text: String, name: String) {
        execute("$name содержит $text") {
            item.hasText(text)
        }
    }

    fun hasAnyText(item: TextViewAssertions, name: String) {
        execute("'$name' содержит какой-либо текст") {
            item.hasAnyText()
        }
    }

    fun containsText(item: TextViewAssertions, text: String, name: String) {
        execute("В тексте поля '$name' содержится $text") {
            item.containsText(text)
        }
    }

    fun isChecked(item: CheckableAssertions, name: String) {
        execute("Параметр '$name' установлен") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions, name: String) {
        execute("Параметр '$name' не установлен") {
            item.isNotChecked()
        }
    }

    fun isDisplayed(item: BaseAssertions, name: String) {
        execute("Элемент '$name' отображается на экране") {
            item.isDisplayed()
        }
    }

    fun scroll(item: KWebViewElement) {
        execute("Scroll '${item.getName()}'") {
            testContext.flakySafely(
                timeoutMs = 150000
            ) {
                item.executeAction { scroll() }
            }
        }
    }
}