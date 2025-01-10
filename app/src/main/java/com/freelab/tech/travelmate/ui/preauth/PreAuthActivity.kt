package com.freelab.tech.travelmate.ui.preauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.freelab.tech.travelmate.ui.navigation.AppNavigation
import com.freelab.tech.travelmate.ui.theme.TravelMateTheme

class PreAuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelMateTheme {
                AppNavigation()
            }
        }
    }
}