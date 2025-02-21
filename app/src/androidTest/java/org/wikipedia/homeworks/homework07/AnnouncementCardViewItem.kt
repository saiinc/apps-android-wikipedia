package org.wikipedia.homeworks.homework07

import android.view.View
import com.google.android.flexbox.FlexboxLayout
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AnnouncementCardViewItem(matcher: Matcher<View>) : KRecyclerItem<AnnouncementCardViewItem>(matcher) {
    val headerImage = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }
    val text = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }
    val customizeButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
        withParent {
            isInstanceOf(FlexboxLayout::class.java)
        }
    }
    val gotItButton = KButton(matcher) {
        withId(R.id.view_announcement_dialog_action_negative)
        withParent {
            isInstanceOf(FlexboxLayout::class.java)
        }
    }
}