package org.wikipedia.homeworks.homework26

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

class CloseSyncReadingsListSmartScenario(testContext: TestContext<*>) : BaseSmartScenario(testContext){
    override val step: String = "Закрывает баннер синхронизации списков"
    override val action: (StepInfo) -> Unit = {
        KView {
            //withId(R.id.negativeButton)
            withId(android.R.id.button2)
        }.click()
    }

    //override fun isConditionMet() = waitElementById("onboarding_view")
    override fun isConditionMet() = waitElementByText("reading list")
}