package org.wikipedia.homeworks.homework11

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen

object ExploreUiScreen: UiScreen<ExploreUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val featured_article = UiView {
        withId(
            packageName = this@ExploreUiScreen.packageName,
            resourceId = "view_featured_article_card_content_container"
        )
    }
}