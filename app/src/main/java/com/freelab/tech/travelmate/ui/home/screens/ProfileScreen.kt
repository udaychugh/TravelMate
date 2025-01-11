package com.freelab.tech.travelmate.ui.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.freelab.tech.travelmate.ui.navigation.LocalHomeNavController
import com.freelab.tech.travelmate.ui.theme.bgBlack

@Composable
fun ProfileScreen() {
    val navController = LocalHomeNavController.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollState()
            )
            .background(
                color = bgBlack
            )
    ) {
        Text(text = "Hello Profile")
    }
}