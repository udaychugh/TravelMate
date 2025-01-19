package com.freelab.tech.travelmate.ui.navigation

import android.content.Context
import com.freelab.tech.travelmate.ui.journey.JourneyScreenActivity

object IntentManager {

    fun gotoHomeActivity() {

    }

    fun gotoJourneyActivity(context: Context) {
        val intent = JourneyScreenActivity.getStartIntent(context)
        context.startActivity(intent)
    }

}