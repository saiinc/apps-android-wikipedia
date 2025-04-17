package org.wikipedia.homeworks.homework21

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class GetDrawable: ViewAction {

    private var drawable: Drawable? = null

    fun getDrawable() = drawable

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(ImageView::class.java)
    }

    override fun getDescription(): String {
        return "get drawable"
    }

    override fun perform(uiController: UiController?, view: View?) {
        drawable = (view as ImageView).drawable
    }
}