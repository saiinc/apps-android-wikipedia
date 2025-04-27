package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView

class KWebVIewList(
    kWebView: KWebView,
    listContainerXPath: String
) : KWebViewBaseElement<KWebVIewList>(kWebView, listContainerXPath) {
    override val self: KWebVIewList = this

    inline fun <reified T: KWebViewItem<T>> childAt(index: Int, function: T.() -> Unit) {
        val item = T::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(kWebView, "$xPath/*[$index]")
            .name(withParent("$index"))
        item.executeAction { scroll() }
        item.function()
    }
}