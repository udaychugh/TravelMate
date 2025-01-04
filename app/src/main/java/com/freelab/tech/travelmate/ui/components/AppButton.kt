package com.freelab.tech.travelmate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(darkOrange, lightOrange),
                    startX = 0f,
                    endX = 0.82f
                ),
                shape = RoundedCornerShape(20.dp)
            )
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}