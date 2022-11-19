package com.example.ipnquizmaker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ipnquizmaker.presentation.screens.create_account.CreateAccountScreen
import com.example.ipnquizmaker.presentation.screens.home.HomeScreen
import com.example.ipnquizmaker.presentation.screens.login.LoginScreen
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
                    startDestination = Screen.LoginScreen.route
                ) {
                    composable(route = Screen.LoginScreen.route) {
                        LoginScreen(navController = navController)
                    }

                    composable(route = Screen.CreateAccountScreen.route) {
                        CreateAccountScreen(navController = navController)
                    }

                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen(navController = navController)
                    }

                    composable(route = Screen.QuizGenerationScreen.route) {
                        QuizGenerationScreen()
                    }
                }
            }
        }
    }
}
