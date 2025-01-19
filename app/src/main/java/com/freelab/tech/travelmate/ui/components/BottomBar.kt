package com.freelab.tech.travelmate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.freelab.tech.travelmate.R
import com.freelab.tech.travelmate.ui.theme.bottomBar

@Composable
fun BottomBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = bottomBar,
                shape = RoundedCornerShape(12.dp)
            ),

    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_cost),
                contentDescription = "Cost Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_fuel_station),
                contentDescription = "Cost Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_traffic),
                contentDescription = "Cost Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_weather),
                contentDescription = "Cost Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_rest_place),
                contentDescription = "Cost Icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )
        }
    }
}
