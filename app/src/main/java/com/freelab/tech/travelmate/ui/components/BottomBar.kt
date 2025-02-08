package com.freelab.tech.travelmate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.freelab.tech.travelmate.R
import com.freelab.tech.travelmate.ui.navigation.LocalJourneyNavController
import com.freelab.tech.travelmate.ui.navigation.NavConstants
import com.freelab.tech.travelmate.ui.theme.bottomBar

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    val navController = LocalJourneyNavController.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                color = bottomBar,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(10.dp),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_cost),
                contentDescription = "Cost Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .clickable {
                        navController.navigate(NavConstants.COST_INFO.screen)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_fuel_station),
                contentDescription = "Fuel Station Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .clickable {
                        navController.navigate(NavConstants.FUEL_INFO.screen)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_traffic),
                contentDescription = "Traffic Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .clickable {
                        navController.navigate(NavConstants.MAPS.screen)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_weather),
                contentDescription = "Weather Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .clickable {
                        navController.navigate(NavConstants.WEATHER.screen)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_rest_place),
                contentDescription = "Rest Place Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .clickable {
                        navController.navigate(NavConstants.REST_PLACES.screen)
                    }
            )
        }
    }
}
