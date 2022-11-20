package com.example.ipnquizmaker.presentation.screens.quiz_suggestions

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ipnquizmaker.R

@ExperimentalAnimationApi
@Composable
fun QuizSuggestionsScreen(
    navController: NavController,
    viewModel: QuizSuggestionsScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val state = viewModel.state

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

        Text(
            text = "Propozycje pojęć do pytań:",
            fontSize =  20.sp,
            modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp),
            fontWeight = FontWeight.Bold
        )

        AnimatedContent(
            targetState = state.isEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .weight(1f)
        ) { targetState ->
            if (!targetState) {
                LazyColumn(verticalArrangement = Arrangement.Top) {
                    items(state) { phrase ->
                        PhraseCard(
                            phrase = phrase,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
            } else {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(color = Color(0xFFEC4545))
                    
                    Text(text = "Odpalanie maszyny...")
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(16.dp)
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEC4545)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "Stwórz quiz!",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun PhraseCard(
    phrase: String,
    modifier: Modifier = Modifier
) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(56.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF3F4F5)
            )
    ) {
        Text(
            text = phrase,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        )

        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            },
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFFEC4545))
        )

        Spacer(modifier = Modifier.width(16.dp))
    }
}