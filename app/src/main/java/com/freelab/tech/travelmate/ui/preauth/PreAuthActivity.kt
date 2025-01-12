package com.freelab.tech.travelmate.ui.preauth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.freelab.tech.travelmate.ui.home.HomeScreenActivity
import com.freelab.tech.travelmate.ui.navigation.PreAuthNavigation
import com.freelab.tech.travelmate.ui.theme.TravelMateTheme

class PreAuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val isAuthenticated = true
        setContent {
            TravelMateTheme {
                PreAuthNavigation()
            }
        }

        if (isAuthenticated) {
            val intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}