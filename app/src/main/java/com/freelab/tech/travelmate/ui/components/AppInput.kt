package com.freelab.tech.travelmate.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun AppInput(
    fieldValue: MutableState<String>,
    label: String,
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
        singleLine = true,
    )
}