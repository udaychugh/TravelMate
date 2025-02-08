package com.freelab.tech.travelmate.ui.journey.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.freelab.tech.travelmate.R
import com.freelab.tech.travelmate.ui.journey.model.RestPlaceData
import com.freelab.tech.travelmate.ui.navigation.LocalJourneyNavController

@Composable
fun RestPlaceScreen() {
    val navController = LocalJourneyNavController.current
}

@Composable
fun RestPlaceItem(
    restPlaceData: RestPlaceData
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            )
            .background(color = restPlaceData.boxColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(restPlaceData.hotelImageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Rest Place Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )

            Column {
                Text(
                    text = restPlaceData.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )

                Text(
                    text = stringResource(
                        R.string.rest_place_screen_person_cost, restPlaceData.cost
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )

                Text(
                    text = stringResource(
                        R.string.rest_place_screen_person_cost, restPlaceData.cost
                    ),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )

                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Rating Icon",
                    tint = Color.White
                )

            }
        }
    }
}