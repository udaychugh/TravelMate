package com.freelab.tech.travelmate.ui.utils

fun String.isValidName(): Boolean {
    return this.length > 2 && this.isNotEmpty()
}

fun String.isValidEmail(): Boolean {
    return this.contains("@") && this.contains(".")
}

object UIUtils {
}