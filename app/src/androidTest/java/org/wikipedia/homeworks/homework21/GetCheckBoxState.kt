package org.wikipedia.homeworks.homework21

import android.view.View
import android.widget.CheckBox
import androidx.appcompat.widget.SwitchCompat
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class GetCheckBoxState: ViewAction {
    private var state: Boolean = false

    fun getState() = state

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(SwitchCompat::class.java)
    }

    override fun getDescription(): String {
        return "get checkbox state"
    }

    override fun perform(uiController: UiController?, view: View?) {
        state = (view as SwitchCompat).isChecked
    }


}