package com.example.ipnquizmaker.presentation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object CreateAccountScreen : Screen("create_account_screen")
    object HomeScreen : Screen("home_screen")
    object QuizGenerationScreen : Screen("quiz_generation_screen")
}