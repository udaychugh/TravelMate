package com.freelab.tech.travelmate.ui.journey.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freelab.tech.travelmate.R
import com.freelab.tech.travelmate.ui.journey.model.WeatherData
import com.freelab.tech.travelmate.ui.navigation.LocalJourneyNavController
import com.freelab.tech.travelmate.ui.theme.bgBlack

@Composable
fun WeatherScreen() {
    val navController = LocalJourneyNavController.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            )
            .background(
                color = bgBlack
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Weather",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp, bottom = 10.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            WeatherInfoBox(
                WeatherData(
                    cityName = "Delhi",
                    country = "In",
                    temp = "30",
                    tempUnit = "°C",
                    icon = R.drawable.ic_profile,
                    boxColor = Color(0x5EF8B4B4)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            WeatherInfoBox(
                WeatherData(
                    cityName = "Mumbai",
                    country = "In",
                    temp = "40",
                    tempUnit = "°C",
                    icon = R.drawable.ic_profile,
                    boxColor = Color(0x5EB4F8C7)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Chance of Rain",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp, bottom = 10.dp)
            )
        }

    }
}

@Composable
fun WeatherInfoBox(
    weatherData: WeatherData
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = 10.dp
            )
            .background(
                color = weatherData.boxColor,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {

                Text(
                    text = "Today",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "${weatherData.temp}${weatherData.tempUnit}",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location Icon",
                        tint = Color.White
                    )

                    Text(
                        text = "${weatherData.cityName}, ${weatherData.country}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
            }

            Image(
                painter = painterResource(id = weatherData.icon),
                contentDescription = "Current Weather Image",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }
    }
}