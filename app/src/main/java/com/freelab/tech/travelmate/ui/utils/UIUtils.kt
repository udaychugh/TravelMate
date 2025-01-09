package com.freelab.tech.travelmate.ui.utils

import android.util.Patterns

fun String.isValidName(): Boolean {
    return this.length > Constants.NAME_LENGTH && this.isNotEmpty()
}

fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPhone(): Boolean {
    return Patterns.PHONE.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return this.length > Constants.PASSWORD_LENGTH
}

object UIUtils {
}