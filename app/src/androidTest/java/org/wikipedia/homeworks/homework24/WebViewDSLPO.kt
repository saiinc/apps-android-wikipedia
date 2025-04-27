package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NamedKScreen

object WebViewDSLPO : NamedKScreen<WebViewDSLPO>() {
    override val screenName: String = "WebViewDSL"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }
    val referencesHeader by lazy {
        KWebViewElement(webView, "//div[contains(@class, 'pcs-edit-section-header')]//h2[@id='References']")
            .name(withParent("Заголовок списка ссылок"))
    }
    val reference by lazy {
        KWebVIewList(webView, "//ol[@class='mw-references references']")
        .name(withParent("Список ссылок"))
    }
    fun getReferencesList(index: Int, function: ReferenceListItem.() -> Unit) {
        reference.childAt<ReferenceListItem>(index, function)
    }
}