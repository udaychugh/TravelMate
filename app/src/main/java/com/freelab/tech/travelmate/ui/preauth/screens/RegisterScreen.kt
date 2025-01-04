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
import com.freelab.tech.travelmate.ui.navigation.LocalNavController
import com.freelab.tech.travelmate.ui.theme.bgBlack

@Composable
fun RegisterScreenOne() {
    val navController = LocalNavController.current

    val name = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val phone = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val confirmPassword = remember {
        mutableStateOf("")
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
                text = "Create a new account",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "Please fill the form to continue",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
            )

            Spacer(modifier = Modifier.height(200.dp))

            AppInput(
                fieldValue = name,
                label = "Full Name"
            )

            AppInput(
                fieldValue = email,
                label = "Email Address",
                keyboardType = KeyboardType.Email
            )

            AppInput(
                fieldValue = phone,
                label = "Phone Number",
                keyboardType = KeyboardType.Phone
            )

            AppInput(
                fieldValue = password,
                label = "Password",
                keyboardType = KeyboardType.Password
            )

            AppInput(
                fieldValue = confirmPassword,
                label = "Confirm Password",
                keyboardType = KeyboardType.Password,
                isLastInput = true
            )

            Spacer(modifier = Modifier.height(100.dp))
            
            AppButton(text = "Next") {
                navController.navigate("register_two")
            }

            Text(
                text = "Already have an account? Log in",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable {
                        navController.navigate("login")
                    }
            )

        }
    }
}

@Composable
fun RegisterScreenTwo() {
    val navController = LocalNavController.current

    val carName = remember {
        mutableStateOf("")
    }

    val modelYear = remember {
        mutableStateOf("")
    }

    val kmsDriven = remember {
        mutableStateOf("")
    }

    val engineType = remember {
        mutableStateOf("")
    }

    val condition = remember {
        mutableStateOf("")
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
                text = "Enter Car Info",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "Please fill the form to continue",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
            )

            Spacer(modifier = Modifier.height(200.dp))

            AppInput(
                fieldValue = carName,
                label = "Car Name"
            )

            AppInput(
                fieldValue = modelYear,
                label = "Model Year",
                keyboardType = KeyboardType.Number
            )

            AppInput(
                fieldValue = kmsDriven,
                label = "Kms Driven",
                keyboardType = KeyboardType.Number
            )

            AppInput(
                fieldValue = engineType,
                label = "Engine Type"
            )

            AppInput(
                fieldValue = condition,
                label = "Condition",
                isLastInput = true
            )

            Spacer(modifier = Modifier.height(100.dp))

            AppButton(text = "Let's Go") {
                navController.navigate("login")
            }
        }
    }
}