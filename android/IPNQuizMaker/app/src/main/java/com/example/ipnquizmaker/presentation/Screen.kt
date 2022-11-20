package com.example.ipnquizmaker.presentation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object QuizGenerationScreen : Screen("quiz_generation_screen")
    object QuizSuggestionsScreen : Screen("quiz_suggestions_screen")
    object QuizPreviewScreen : Screen("quiz_preview_screen")
}