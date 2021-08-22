package com.john.kot.test

object RegistrationUtil {
    private val exitingUsers = listOf("Peter","Carl")

    /**
     * the input is not valid if...
     * ...the username /password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the pasword contains less than 2 digits
     */
    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmedPassword: String
    ):Boolean{
        return false
    }
}