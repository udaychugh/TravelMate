package com.freelab.tech.travelmate.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.freelab.tech.travelmate.ui.theme.bgInput
import com.freelab.tech.travelmate.ui.theme.darkOrange

@Composable
fun AppInput(
    fieldValue: MutableState<String>,
    label: String,
    isError: MutableState<Boolean>,
    errorText: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    isLastInput: Boolean = false
) {
    val isPassword = keyboardType == KeyboardType.Password
    val passwordVisible = remember { mutableStateOf(false) }

    TextField(
        value = fieldValue.value,
        onValueChange = {
            fieldValue.value = it
            if (isError.value) {
                isError.value = false
            }
        },
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
        visualTransformation = if (isPassword && !passwordVisible.value) {
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
            errorTextColor = Color.White,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = darkOrange,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            cursorColor = darkOrange
        ),
        trailingIcon = {
            if (isPassword) {
                Text(
                    text = if (passwordVisible.value) "🙈" else "👁️",
                    modifier = Modifier.clickable {
                        passwordVisible.value = !passwordVisible.value
                    }
                )
            }
        }
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