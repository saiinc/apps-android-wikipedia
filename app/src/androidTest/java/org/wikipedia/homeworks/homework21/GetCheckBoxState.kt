package org.wikipedia.homeworks.homework21

import android.view.View
import android.widget.CheckBox
import android.widget.Checkable
import androidx.appcompat.widget.SwitchCompat
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

class GetCheckBoxState: ViewAction {
    private var state: Boolean = false

    fun getState() = state

    override fun getConstraints(): Matcher<View> {
        return Matchers.allOf(ViewMatchers.isAssignableFrom(View::class.java),
            object : TypeSafeMatcher<View>() {
                override fun describeTo(description: Description) {
                    description.appendText("is assignable from class: " + Checkable::class.java)
                }

                override fun matchesSafely(view: View) =
                    Checkable::class.java.isAssignableFrom(view.javaClass)
            })
    }

    override fun getDescription(): String {
        return "get checkbox state"
    }

    override fun perform(uiController: UiController?, view: View?) {
        state = (view as SwitchCompat).isChecked
    }


}