package com.example.ipnquizmaker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ipnquizmaker.presentation.screens.home.HomeScreen
import com.example.ipnquizmaker.presentation.screens.quiz_generation.QuizGenerationScreen
import com.example.ipnquizmaker.presentation.screens.quiz_preview.QuizPreviewScreen
import com.example.ipnquizmaker.presentation.screens.quiz_suggestions.QuizSuggestionsScreen
import com.example.ipnquizmaker.presentation.ui.theme.IPNQuizMakerTheme
import org.json.JSONArray
import org.json.JSONObject

@ExperimentalAnimationApi
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

                    composable(route = Screen.QuizSuggestionsScreen.route) {
                        QuizSuggestionsScreen(navController = navController)
                    }

                    composable(route = Screen.QuizPreviewScreen.route) {
                        QuizPreviewScreen(navController = navController)
                    }
                }
            }
        }
    }
}

fun JSONObject.toMap(): Map<String, *> = keys().asSequence().associateWith {
    when (val value = this[it])
    {
        is JSONArray ->
        {
            val map = (0 until value.length()).associate { Pair(it.toString(), value[it]) }
            JSONObject(map).toMap().values.toList()
        }
        is JSONObject -> value.toMap()
        JSONObject.NULL -> null
        else            -> value
    }
}