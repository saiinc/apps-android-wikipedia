package org.wikipedia.homeworks.homework29

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework26.SavedArticlesScreen

object LoginScreen: NamedKScreen<LoginScreen>() {
    override val screenName = "Экран авторизации"
    override val layoutId = null
    override val viewClass = null

    val loginField by lazy {
        KEditText {
            withHint("Username")
        }.name(withParent("Поле ввода логина"))
    }

    val passwordField by lazy {
        KEditText {
            withHint("Password")
        }.name(withParent("Поле ввода пароля"))
    }

    val loginButton by lazy {
        KTextView {
            withId(R.id.login_button)
        }.name(SavedArticlesScreen.withParent("Кнопка авторизации"))
    }
}