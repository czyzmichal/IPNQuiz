package com.example.ipnquizmaker.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ipnquizmaker.R
import com.example.ipnquizmaker.presentation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.home),
            fontSize = 32.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                navController.navigate(Screen.QuizGenerationScreen.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.create_new_quiz))
        }
    }
}