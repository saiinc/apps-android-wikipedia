package org.wikipedia.homeworks.homework22

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasIdAction(private val targetID: Int): ViewAction {

    private var result: Boolean = false

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "Checks if the view has the target ID."
    }

    override fun perform(uiController: UiController?, view: View?) {
        val nonNullView = requireNotNull(view) { "View must not be null" }
        result = when {
            nonNullView.id == targetID -> true
            nonNullView.findViewById<View>(targetID) != null -> true
            else -> false
        }
    }

    fun getResult() = result
}

class HasClassAction(private val targetClass: Class<out View>): ViewAction {
    private var result = false

    fun getResult() : Boolean = result

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "Check if the view has child Class"
    }

    override fun perform(uiController: UiController?, view: View?) {
        val notNullView = requireNotNull(view) {"View must not be null"}
        result = if (targetClass.isAssignableFrom(notNullView::class.java)) {
             true
        } else {
            checkInnerView(notNullView)
        }
    }


    private fun checkInnerView(checkable: View): Boolean {
        if (targetClass.isAssignableFrom(checkable::class.java)) return true
        if (checkable is ViewGroup) {
            checkable.children.forEach {
                if (checkInnerView(it)) return true
            }
        }
        return false
    }
}