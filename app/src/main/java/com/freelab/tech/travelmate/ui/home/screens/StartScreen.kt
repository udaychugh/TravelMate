package com.freelab.tech.travelmate.ui.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freelab.tech.travelmate.R
import com.freelab.tech.travelmate.ui.navigation.LocalHomeNavController
import com.freelab.tech.travelmate.ui.theme.bgBlack
import com.freelab.tech.travelmate.ui.theme.darkOrange

@Composable
@Preview(showBackground = true)
fun StartScreen() {
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
        Box(
            modifier = Modifier
                .height(320.dp)
                .fillMaxWidth()
                .background(
                    color = darkOrange,
                    shape = RoundedCornerShape(
                        bottomEnd = 70.dp
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(
                        id = R.string.start_screen_title
                    ),
                    color = Color.White,
                    fontSize = 20.sp
                )
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More options",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            LocationSelector()

        }
    }
}

@Composable
fun LocationSelector() {
    val startLocation = remember {
        mutableStateOf("")
    }

    val endLocation = remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = rememberVectorPainter(
                image = ImageVector.vectorResource(id = R.drawable.ic_location_marks)
            ),
            contentDescription = "",
            modifier = Modifier
                .height(75.dp)
                .width(10.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    start = 30.dp,
                    end = 30.dp
                )
        ) {
            Text(
                text = stringResource(
                    id = R.string.start_screen_location_from
                ),
                color = Color.LightGray,
                fontSize = 14.sp
            )

            LocationInput(
                stringResource(
                    id = R.string.start_screen_location_from_hint
                ),
                startLocation
            )

            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(
                    id = R.string.start_screen_location_to
                ),
                color = Color.LightGray,
                fontSize = 14.sp
            )

            LocationInput(
                stringResource(
                    id = R.string.start_screen_location_to_hint
                ),
                endLocation
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_up_down),
            contentDescription = "Reverse Options",
        )

    }
}

@Composable
fun LocationInput(
    hint: String,
    fieldValue: MutableState<String>,
) {
    BasicTextField(
        value = fieldValue.value,
        onValueChange = { fieldValue.value = it },
        singleLine = true,
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        decorationBox = { innerTextField ->
            if (fieldValue.value.isEmpty()) {
                Text(
                    text = hint,
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
            innerTextField()
        }
    )
}