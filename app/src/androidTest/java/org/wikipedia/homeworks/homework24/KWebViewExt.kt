package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXpath(xPath: String) = KWebViewElement(this, xPath)