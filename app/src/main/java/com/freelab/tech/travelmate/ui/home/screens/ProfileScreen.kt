package com.freelab.tech.travelmate.ui.home.screens

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freelab.tech.travelmate.BuildConfig
import com.freelab.tech.travelmate.R
import com.freelab.tech.travelmate.ui.navigation.LocalHomeNavController
import com.freelab.tech.travelmate.ui.theme.bgBlack
import com.freelab.tech.travelmate.ui.theme.lightOrange


@Composable
fun ProfileScreen() {
    val navController = LocalHomeNavController.current
    val appVersion = BuildConfig.VERSION_NAME
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            )
            .background(
                color = bgBlack
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile Image",
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .width(100.dp)
            )

            Text(
                text = "User Name",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 5.dp,
                        bottom = 5.dp
                    )
            )


            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.profile_screen_edit),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(
                            color = lightOrange,
                            shape = RoundedCornerShape(
                                50.dp
                            )
                        )
                        .padding(
                            5.dp
                        ),
                )
            }

            Partition()

            UserVerificationInfo(info = "username@email.com", isVerified = false)

            UserVerificationInfo(info = "+91 98765 43210", isVerified = false)

            Partition()

            Text(
                text = stringResource(id = R.string.profile_screen_about_app),
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp
                    )
            )

            Text(
                text = stringResource(id = R.string.profile_screen_version, appVersion),
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp
                    )
            )

            Text(
                text = stringResource(id = R.string.profile_screen_logout),
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp
                    )
            )

        }
    }
}

@Composable
fun Partition() {
    Spacer(modifier = Modifier.height(25.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.DarkGray)
    )

    Spacer(modifier = Modifier.height(25.dp))
}

@Composable
fun UserVerificationInfo(info: String, isVerified: Boolean) {
    val (status, color) = if (isVerified) {
        Pair(stringResource(id = R.string.app_verified), Color.Green)
    } else {
        Pair(stringResource(id = R.string.app_not_verified), Color.Red)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 10.dp,
                bottom = 10.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = info,
            color = Color.White,
            fontSize = 16.sp
        )

        Text(
            text = status,
            color = color,
            fontSize = 12.sp
        )
    }
}