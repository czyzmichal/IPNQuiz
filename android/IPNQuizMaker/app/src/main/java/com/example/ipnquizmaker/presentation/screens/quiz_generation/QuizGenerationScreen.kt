package com.example.ipnquizmaker.presentation.screens.quiz_generation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ipnquizmaker.R
import com.example.ipnquizmaker.presentation.Screen

@Composable
fun QuizGenerationScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(color = Color(0xFFEC4545))
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_forward_arrow),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .graphicsLayer { rotationZ = 180f }
                )
            }
        }

        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(
                    text = "Wpisz temat quizu",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFF3F4F5)
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFFEC4545),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_short_test),
                    contentDescription = "",
                    modifier = Modifier
                        .size(size = 80.dp)
                        .padding(start = 16.dp)
                )
                
                Text(
                    text = "Szybki test",
                    modifier = Modifier.padding(start = 16.dp)
                )
                
                Text(
                    text = "(10 pytań)",
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFF3F4F5)
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_long_test),
                    contentDescription = "",
                    modifier = Modifier
                        .size(size = 80.dp)
                        .padding(start = 16.dp)
                )

                Text(
                    text = "Sprawdzian",
                    modifier = Modifier.padding(start = 16.dp)
                )

                Text(
                    text = "(20 pytań)",
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }
        }

        Text(
            text = "Poziom:",
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF3F4F5)
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFFEC4545),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Text(
                text = "Podstawowy",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF3F4F5)
                )
        ) {
            Text(
                text = "Ponad-podstawowy",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF3F4F5)
                )
        ) {
            Text(
                text = "Rozszerzony",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.weight(1f).padding(16.dp)
        ) {
            Button(
                onClick = { navController.navigate(Screen.QuizSuggestionsScreen.route) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEC4545)),
                modifier = Modifier.fillMaxWidth().height(48.dp)
            ) {
                Text(
                    text = "Dalej",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}