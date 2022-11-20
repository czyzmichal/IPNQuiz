package com.example.ipnquizmaker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ipnquizmaker.presentation.screens.home.HomeScreen
import com.example.ipnquizmaker.presentation.screens.quiz_generation.QuizGenerationScreen
import com.example.ipnquizmaker.presentation.ui.theme.IPNQuizMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPNQuizMakerTheme {
                val navController = rememberNavController()
                
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ) {
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen(navController = navController)
                    }

                    composable(route = Screen.QuizGenerationScreen.route) {
                        QuizGenerationScreen(navController = navController)
                    }
                }
            }
        }
    }
}
