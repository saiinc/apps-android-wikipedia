package org.wikipedia.homeworks.homework29

import org.wikipedia.BuildConfig

object Users {
    val alphaLogin = "alphaLogin"
    val betaLogin = "betaLogin"
    val the_saionji = "the_saionji"
}

object Credentials {
    private val map = mapOf(
        Users.alphaLogin to BuildConfig.alphaLogin,
        Users.betaLogin to BuildConfig.betaLogin,
        Users.the_saionji to BuildConfig.the_saionji
    )

    fun getPassword(user: String) : String {
        return map.getOrElse(user) {
            throw IllegalArgumentException("$user пользователя нет")
        }
    }
}