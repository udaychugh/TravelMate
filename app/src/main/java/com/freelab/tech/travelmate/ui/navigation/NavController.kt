package com.freelab.tech.travelmate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freelab.tech.travelmate.ui.preauth.screens.IntroScreen
import com.freelab.tech.travelmate.ui.preauth.screens.LoginScreen
import com.freelab.tech.travelmate.ui.preauth.screens.RegisterScreenOne
import com.freelab.tech.travelmate.ui.preauth.screens.RegisterScreenTwo

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("Nav Controller not provided")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = "intro") {
            composable("intro") {
                IntroScreen()
            }
            composable("register_one") {
                RegisterScreenOne()
            }
            composable("register_two") {
                RegisterScreenTwo()
            }
            composable("login") {
                LoginScreen()
            }
        }
    }
}
