package com.freelab.tech.travelmate.ui.preauth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freelab.tech.travelmate.ui.components.AppButton
import com.freelab.tech.travelmate.ui.components.AppInput
import com.freelab.tech.travelmate.ui.navigation.LocalPreAuthNavController
import com.freelab.tech.travelmate.ui.theme.bgBlack
import com.freelab.tech.travelmate.ui.utils.isValidEmail
import com.freelab.tech.travelmate.ui.utils.isValidPassword
import com.freelab.tech.travelmate.ui.utils.isValidPhone

@Composable
fun LoginScreen() {
    val navController = LocalPreAuthNavController.current
    val authId = remember {
        mutableStateOf("")
    }

    val authIdError = remember {
        mutableStateOf(false)
    }

    val password = remember {
        mutableStateOf("")
    }

    val passwordError = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = bgBlack
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Welcome",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "Please sign in to your account",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
            )

            Spacer(modifier = Modifier.height(50.dp))

            AppInput(
                fieldValue = authId,
                label = "Email/Phone",
                keyboardType = KeyboardType.Text,
                isError = authIdError,
                errorText = "Please enter a valid Email or Phone"
            )

            AppInput(
                fieldValue = password,
                label = "Password",
                keyboardType = KeyboardType.Password,
                isError = passwordError,
                errorText = "Please enter min 6 length of password"
            )

            Spacer(modifier = Modifier.height(50.dp))

            AppButton(text = "Sign In") {
                if (!authId.value.isValidEmail() && !authId.value.isValidPhone()) {
                    authIdError.value = true
                    return@AppButton
                }

                if (!password.value.isValidPassword()) {
                    passwordError.value = true
                    return@AppButton
                }


            }

            Text(
                text = "New User? Signup",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable {
                        navController.navigate("register_one")
                    }
            )

        }
    }
}