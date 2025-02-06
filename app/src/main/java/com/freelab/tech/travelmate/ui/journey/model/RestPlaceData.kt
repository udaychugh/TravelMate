package com.freelab.tech.travelmate.ui.journey.model

import androidx.compose.ui.graphics.Color

data class RestPlaceData(
    val title: String,
    val cost: Int,
    val distance: Int,
    val distanceUnit: String,
    val ratings: Int,
    val boxColor: Color,
    val hotelImageUrl: String
)