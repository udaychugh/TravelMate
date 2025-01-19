package com.freelab.tech.travelmate.ui.journey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.freelab.tech.travelmate.ui.navigation.JourneyNavigation
import com.freelab.tech.travelmate.ui.theme.TravelMateTheme

class JourneyScreenActivity: ComponentActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, JourneyScreenActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelMateTheme {
                JourneyNavigation()
            }
        }
    }

}