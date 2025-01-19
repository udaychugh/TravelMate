package com.freelab.tech.travelmate.ui.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.freelab.tech.travelmate.R
import com.freelab.tech.travelmate.ui.components.AppButton
import com.freelab.tech.travelmate.ui.navigation.LocalHomeNavController
import com.freelab.tech.travelmate.ui.navigation.NavConstants
import com.freelab.tech.travelmate.ui.theme.bgBlack
import com.freelab.tech.travelmate.ui.utils.Constants

@Composable
@Preview(showBackground = true)
fun HomeScreen() {
    val navController = LocalHomeNavController.current
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
            Spacer(modifier = Modifier.height(60.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.home_screen_hello, "User name"),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )

                    Text(
                        text = stringResource(id = R.string.home_screen_subtitle),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile Image",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clickable {
                            navController.navigate(NavConstants.PROFILE.screen)
                        }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(Constants.AD_BANNER)
                    .crossfade(true)
                    .build(),
                contentDescription = "Holiday Image Banner",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(30.dp))

            AppButton(text = stringResource(R.string.home_screen_start_trip)) {
                navController.navigate(NavConstants.START.screen)
            }
        }
    }
}