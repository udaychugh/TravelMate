package com.freelab.tech.travelmate.ui.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.freelab.tech.travelmate.ui.journey.JourneyScreenActivity

object IntentManager {

    private fun fireIntent(context: Context, intent: Intent) {
        context.startActivity(intent)
        (context as? Activity)?.finish()
    }

    fun gotoHomeActivity() {

    }

    fun gotoJourneyActivity(context: Context) {
        val intent = JourneyScreenActivity.getStartIntent(context)
        fireIntent(context, intent)
    }

}