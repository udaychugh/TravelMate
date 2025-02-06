package com.freelab.tech.travelmate.ui.journey.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
import com.freelab.tech.travelmate.ui.navigation.LocalPreAuthNavController
import com.freelab.tech.travelmate.ui.theme.bgBlack

@Composable
fun WeatherScreen() {
    val navController = LocalPreAuthNavController.current
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
        Spacer(modifier = Modifier.height(60.dp))

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

@Composable
fun WeatherInfoBox(
    weatherData: WeatherData
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            )
            .background(color = weatherData.boxColor)
    ) {
        Text(
            text = "Today",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${weatherData.temp}${weatherData.tempUnit}",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Image(
                painter = painterResource(id = weatherData.icon),
                contentDescription = "Current Weather Image",
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .width(100.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
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
}