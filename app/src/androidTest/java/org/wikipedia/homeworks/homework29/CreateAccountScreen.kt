package org.wikipedia.homeworks.homework29

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.name

object CreateAccountScreen: NamedKScreen<CreateAccountScreen>() {
    override val screenName = "Экран создания аккаунта"
    override val layoutId = null
    override val viewClass = null

    val loginButton by lazy {
        KTextView {
            withId(R.id.create_account_login_button)
        }.name(withParent("Кнопка логина"))
    }
}