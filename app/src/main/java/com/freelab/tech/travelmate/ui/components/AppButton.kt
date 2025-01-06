package com.freelab.tech.travelmate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freelab.tech.travelmate.ui.theme.darkOrange
import com.freelab.tech.travelmate.ui.theme.lightOrange

@Composable
fun AppButton(text: String, listener: () -> Unit) {
    Button(
        onClick = { listener.invoke() },
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonColors(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(darkOrange, darkOrange, lightOrange)
                ),
                shape = RoundedCornerShape(12.dp)
            )
        ) {
            Text(
                text = text,
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Center)
            )
        }
    }
}