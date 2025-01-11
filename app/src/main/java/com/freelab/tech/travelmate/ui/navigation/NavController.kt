package com.freelab.tech.travelmate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freelab.tech.travelmate.ui.home.screens.HomeScreen
import com.freelab.tech.travelmate.ui.home.screens.ProfileScreen
import com.freelab.tech.travelmate.ui.home.screens.StartScreen
import com.freelab.tech.travelmate.ui.preauth.screens.IntroScreen
import com.freelab.tech.travelmate.ui.preauth.screens.LoginScreen
import com.freelab.tech.travelmate.ui.preauth.screens.RegisterScreenOne
import com.freelab.tech.travelmate.ui.preauth.screens.RegisterScreenTwo

val LocalPreAuthNavController = staticCompositionLocalOf<NavHostController> {
    error("Pre Auth Nav Controller not provided")
}

val LocalHomeNavController = staticCompositionLocalOf<NavHostController> {
    error("Home Nav controller not provided")
}

@Composable
fun PreAuthNavigation() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalPreAuthNavController provides navController) {
        NavHost(navController = navController, startDestination = NavConstants.INTRO.screen) {
            composable(NavConstants.INTRO.screen) {
                IntroScreen()
            }
            composable(NavConstants.REGISTER_ONE.screen) {
                RegisterScreenOne()
            }
            composable(NavConstants.REGISTER_TWO.screen) {
                RegisterScreenTwo()
            }
            composable(NavConstants.LOGIN.screen) {
                LoginScreen()
            }
        }
    }
}


@Composable
fun HomeNavigation() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalHomeNavController provides  navController) {
        NavHost(navController = navController, startDestination = NavConstants.START.screen) {
            composable(NavConstants.START.screen) {
                StartScreen()
            }
            composable(NavConstants.HOME.screen) {
                HomeScreen()
            }
            composable(NavConstants.PROFILE.screen) {
                ProfileScreen()
            }

        }
    }
}
