package org.wikipedia.suggestededits

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.Snackbar
import org.wikipedia.R
import org.wikipedia.WikipediaApp
import org.wikipedia.auth.AccountUtil
import org.wikipedia.descriptions.DescriptionEditActivity.Action
import org.wikipedia.util.FeedbackUtil

object SuggestedEditsSnackbars {

    fun interface OpenPageListener {
        fun open(actionView: View)
    }

    private const val MAX_SHOW_PER_SESSION = 2
    private val snackbarSessionMap = mutableMapOf<String, Int>()

    fun show(activity: Activity, action: Action?, sequentialSnackbar: Boolean = true, targetLanguageCode: String? = null,
             enableViewAction: Boolean = false, listener: OpenPageListener? = null) {
        val app = WikipediaApp.instance
        if (sequentialSnackbar) {
            val snackbar = FeedbackUtil.makeSnackbar(activity,
                    if ((action == Action.TRANSLATE_DESCRIPTION || action == Action.TRANSLATE_CAPTION) &&
                            app.languageState.appLanguageCodes.size > 1) {
                        activity.getString(
                                if (action == Action.TRANSLATE_DESCRIPTION) {
                                    R.string.description_edit_success_saved_in_lang_snackbar
                                } else {
                                    R.string.description_edit_success_saved_image_caption_in_lang_snackbar
                                }, app.languageState.getAppLanguageLocalizedName(targetLanguageCode))
                    } else {
                        activity.getString(
                                when (action) {
                                    Action.ADD_DESCRIPTION -> R.string.description_edit_success_saved_snackbar
                                    Action.ADD_IMAGE_TAGS -> R.string.description_edit_success_saved_image_tags_snackbar
                                    else -> R.string.description_edit_success_saved_image_caption_snackbar
                                })
                    })
            if (enableViewAction && listener != null) {
                snackbar.setAction(R.string.suggested_edits_article_cta_snackbar_action) { listener.open(it) }
            }

            snackbar.addCallback(object : Snackbar.Callback() {
                        override fun onDismissed(transientBottomBar: Snackbar, @DismissEvent event: Int) {
                            if (activity.isDestroyed) {
                                return
                            }
                            showFeedLinkSnackbar(activity, action)
                        }
                    })

            snackbar.show()
        } else {
            showFeedLinkSnackbar(activity, action)
        }
    }

    private fun showFeedLinkSnackbar(activity: Activity, action: Action?) {
        if (action != null && getSessionCount(activity, action) < MAX_SHOW_PER_SESSION) {
            FeedbackUtil.makeSnackbar(activity, activity.getString(R.string.description_edit_success_se_general_feed_link_snackbar))
                    .setAction(R.string.suggested_edits_tasks_onboarding_get_started) {
                        activity.startActivity(SuggestionsActivity.newIntent(activity, action))
                    }
                    .addCallback(object : Snackbar.Callback() {
                        override fun onDismissed(transientBottomBar: Snackbar, @DismissEvent event: Int) {
                            if (!activity.isDestroyed) {
                                AccountUtil.maybeShowTempAccountWelcome(activity)
                            }
                        }
                    })
                    .show()
            incrementSessionMap(activity, action)
        } else {
            AccountUtil.maybeShowTempAccountWelcome(activity)
        }
    }

    private fun incrementSessionMap(activity: Activity, action: Action) {
        snackbarSessionMap[getMapKey(activity, action)] = getSessionCount(activity, action) + 1
    }

    private fun getSessionCount(activity: Activity, action: Action): Int {
        return snackbarSessionMap.getOrPut(getMapKey(activity, action), { 0 })
    }

    private fun getMapKey(activity: Activity, action: Action): String {
        return activity.componentName.className + "." + action.name
    }
}
