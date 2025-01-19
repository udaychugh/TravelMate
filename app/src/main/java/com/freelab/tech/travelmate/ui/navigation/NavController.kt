package com.freelab.tech.travelmate.ui.navigation

import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import com.freelab.tech.travelmate.ui.journey.screens.CostInfoScreen
import com.freelab.tech.travelmate.ui.journey.screens.FuelInfoScreen
import com.freelab.tech.travelmate.ui.journey.screens.MapsScreen
import com.freelab.tech.travelmate.ui.journey.screens.RestPlaceScreen
import com.freelab.tech.travelmate.ui.journey.screens.WeatherScreen
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

val LocalJourneyNavController = staticCompositionLocalOf<NavHostController> {
    error("Journey Nav controller not provided")
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
        NavHost(navController = navController, startDestination = NavConstants.HOME.screen) {
            composable(NavConstants.START.screen) {
                StartScreen()
            }
            composable(NavConstants.HOME.screen,
                enterTransition = {
                    return@composable scaleIn()
                }, exitTransition = {
                    return@composable scaleOut()
                }) {
                HomeScreen()
            }
            composable(NavConstants.PROFILE.screen,
                enterTransition = {
                    return@composable scaleIn()
                }, exitTransition = {
                    return@composable scaleOut()
                }) {
                ProfileScreen()
            }

        }
    }
}

@Composable
fun JourneyNavigation() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalHomeNavController provides navController) {
        NavHost(navController = navController, startDestination = NavConstants.MAPS.screen) {
            composable(NavConstants.MAPS.screen){
                MapsScreen()
            }
            composable(NavConstants.COST_INFO.screen){
                CostInfoScreen()
            }
            composable(NavConstants.FUEL_INFO.screen){
                FuelInfoScreen()
            }
            composable(NavConstants.REST_PLACES.screen){
                RestPlaceScreen()
            }
            composable(NavConstants.WEATHER.screen){
                WeatherScreen()
            }

        }
    }
}
