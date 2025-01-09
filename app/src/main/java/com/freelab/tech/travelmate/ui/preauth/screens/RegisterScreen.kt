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
import com.freelab.tech.travelmate.ui.utils.isValidEmail
import com.freelab.tech.travelmate.ui.utils.isValidName
import com.freelab.tech.travelmate.ui.utils.isValidPassword
import com.freelab.tech.travelmate.ui.utils.isValidPhone

@Composable
fun RegisterScreenOne() {
    val navController = LocalNavController.current

    val name = remember {
        mutableStateOf("")
    }
    val nameError = remember {
        mutableStateOf(false)
    }
    val email = remember {
        mutableStateOf("")
    }
    val emailError = remember {
        mutableStateOf(false)
    }
    val phone = remember {
        mutableStateOf("")
    }
    val phoneError = remember {
        mutableStateOf(false)
    }
    val password = remember {
        mutableStateOf("")
    }
    val passwordError = remember {
        mutableStateOf(false)
    }
    val confirmPassword = remember {
        mutableStateOf("")
    }
    val confirmError = remember {
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
                text = "Create a new account",
                fontSize = 24.sp,
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

            Spacer(modifier = Modifier.height(50.dp))

            AppInput(
                fieldValue = name,
                label = "Full Name",
                isError = nameError,
                errorText = "Name is Invalid"
            )

            AppInput(
                fieldValue = email,
                label = "Email Address",
                keyboardType = KeyboardType.Email,
                isError = emailError,
                errorText = "Please enter a valid Email containing @ in it"
            )

            AppInput(
                fieldValue = phone,
                label = "Phone Number",
                keyboardType = KeyboardType.Phone,
                isError = phoneError,
                errorText = "Please enter a valid Phone number"
            )

            AppInput(
                fieldValue = password,
                label = "Password",
                keyboardType = KeyboardType.Password,
                isError = passwordError,
                errorText = "Please enter a min 6 length of password"
            )

            AppInput(
                fieldValue = confirmPassword,
                label = "Confirm Password",
                keyboardType = KeyboardType.Password,
                isLastInput = true,
                isError = confirmError,
                errorText = "Password fields doesn't match"
            )

            Spacer(modifier = Modifier.height(50.dp))
            
            AppButton(text = "Next") {
                if (!name.value.isValidName()) {
                    nameError.value = true
                    return@AppButton
                }
                if (!email.value.isValidEmail()) {
                    emailError.value = true
                    return@AppButton
                }
                if (!phone.value.isValidPhone()) {
                    phoneError.value = true
                    return@AppButton
                }
                if (!password.value.isValidPassword()) {
                    passwordError.value = true
                    return@AppButton
                }
                if (confirmPassword.value != password.value) {
                    confirmError.value = true
                    return@AppButton
                }
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
    val carNameError = remember {
        mutableStateOf(false)
    }
    val modelYear = remember {
        mutableStateOf("")
    }
    val modelYearError = remember {
        mutableStateOf(false)
    }
    val kmsDriven = remember {
        mutableStateOf("")
    }
    val kmsDrivenError = remember {
        mutableStateOf(false)
    }
    val engineType = remember {
        mutableStateOf("")
    }
    val engineTypeError = remember {
        mutableStateOf(false)
    }
    val condition = remember {
        mutableStateOf("")
    }
    val conditionError = remember {
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
                text = "Enter Car Info",
                fontSize = 24.sp,
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

            Spacer(modifier = Modifier.height(50.dp))

            AppInput(
                fieldValue = carName,
                label = "Car Name",
                isError = carNameError,
                errorText = "Please enter a car name"
            )

            AppInput(
                fieldValue = modelYear,
                label = "Model Year",
                keyboardType = KeyboardType.Number,
                isError = modelYearError,
                errorText = "Please enter a valid model year"
            )

            AppInput(
                fieldValue = kmsDriven,
                label = "Kms Driven",
                keyboardType = KeyboardType.Number,
                isError = kmsDrivenError,
                errorText = "Please enter a valid KMs Driven"
            )

            AppInput(
                fieldValue = engineType,
                label = "Engine Type",
                isError = engineTypeError,
                errorText = "Please select a valid engine type"
            )

            AppInput(
                fieldValue = condition,
                label = "Condition",
                isLastInput = true,
                isError = conditionError,
                errorText = "Please select a valid condition of your car"
            )

            Spacer(modifier = Modifier.height(50.dp))

            AppButton(text = "Let's Go") {
                navController.navigate("login")
            }

            Text(
                text = "I prefer to travel via public transport",
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