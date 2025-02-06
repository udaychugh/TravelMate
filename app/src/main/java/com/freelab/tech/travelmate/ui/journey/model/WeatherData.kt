package com.freelab.tech.travelmate.ui.journey.model

import androidx.compose.ui.graphics.Color

data class WeatherData(
    val cityName: String,
    val country: String,
    val temp: String,
    val tempUnit: String,
    val icon: Int,
    val boxColor: Color
)