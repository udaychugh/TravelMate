package com.freelab.tech.travelmate.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.freelab.tech.travelmate.ui.theme.bgInput
import com.freelab.tech.travelmate.ui.theme.darkOrange
import java.lang.Error

@Composable
fun AppInput(
    fieldValue: MutableState<String>,
    label: String,
    isError: MutableState<Boolean>,
    errorText: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    isLastInput: Boolean = false
) {
    TextField(
        value = fieldValue.value,
        onValueChange = { fieldValue.value = it },
        label = {
            Text(label)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = if (isLastInput) {
                ImeAction.Done
            } else {
                ImeAction.Next
            }
        ),
        visualTransformation = if (keyboardType == KeyboardType.Password) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        isError = isError.value,
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color.White,
            unfocusedContainerColor = bgInput,
            focusedContainerColor = bgInput,
            errorContainerColor = bgInput,
            focusedTextColor = Color.White,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = darkOrange,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            cursorColor = darkOrange
        )
    )
    if (isError.value) {
        Text(
            text = errorText,
            color = Color.Red,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}