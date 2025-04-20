package org.wikipedia.homeworks.homework07

import android.view.View
import com.google.android.flexbox.FlexboxLayout
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class AnnouncementCardViewItem(matcher: Matcher<View>) : KRecyclerItem<AnnouncementCardViewItem>(matcher) {
    val headerImage by lazy {
        KImageView(matcher) {
            withId(R.id.view_announcement_header_image)
        }.name(withParent("Основное изображение"))
    }
    val text by lazy {
        KTextView(matcher) {
            withId(R.id.view_announcement_text)
        }.name(withParent("Текст"))
    }
    val customizeButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_positive)
            withParent {
                isInstanceOf(FlexboxLayout::class.java)
            }
        }.name(withParent("Кнопка Customize"))
    }
    val gotItButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_dialog_action_negative)
            withParent {
                isInstanceOf(FlexboxLayout::class.java)
            }
        }.name(withParent("Кнопка 'Got it'"))
    }
}