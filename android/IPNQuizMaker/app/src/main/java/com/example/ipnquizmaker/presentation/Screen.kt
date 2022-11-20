package com.example.ipnquizmaker.presentation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object QuizGenerationScreen : Screen("quiz_generation_screen")
}