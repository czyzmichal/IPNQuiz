package com.example.ipnquizmaker.presentation.screens.quiz_preview

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ipnquizmaker.R

@Composable
fun QuizPreviewScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
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
            text = "Quiz \"Powstanie warszawskie\"",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "10 pytań, poziom podstawowy",
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .height(56.dp)
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF3F4F5)
                )
                .clickable {
                    // TODO: download PDF
                }
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_download_pdf),
                contentDescription = "",
                modifier = Modifier.size(size = 28.dp)
            )

            Text(
                text = "Pobierz Quiz",
                fontSize = 12.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )
        }

        listOf(
            Question(
                question = "Powstanie Warszawskie było wymierzone militarnie przeciw ________",
                answersMap = mapOf(
                    "A)" to "ZSRR",
                    "B)" to "3 Rzeszy",
                    "C)" to "RP",
                ),
                correctAnswer = "B)",
                source = "https://www.google.pl"
            ),
            Question(
                question = "Operacja wojskowa zorganizowana i podjęta przez oddziały Armii Krajowej przeciw wojskom niemieckim to ________",
                answersMap = mapOf(
                    "A)" to "ZSRR",
                    "B)" to "Akcja “Burza”",
                    "C)" to "RP",
                ),
                correctAnswer = "B)",
                source = "https://www.google.pl"
            )
        ).forEachIndexed { index, question ->
            QuizQuestionCard(
                questionNumber = index + 1,
                question = question.question,
                answersMap = question.answersMap,
                correctAnswer = question.correctAnswer,
                source = question.source,
                modifier = Modifier.padding(all = 16.dp)
            )
        }
    }
}

@Composable
fun QuizQuestionCard(
    questionNumber: Int,
    question: String,
    answersMap: Map<String, String>,
    correctAnswer: String,
    source: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF3F4F5)
            )
    ) {
        Text(
            text = "Pytanie $questionNumber",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
        )

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .padding(horizontal = 16.dp)
                .background(color = Color(0xFFEC4545))
                .fillMaxWidth()
        )

        Text(
            text = question,
            fontSize = 12.sp,
            modifier = Modifier.padding(all = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
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
                    color = Color(if (correctAnswer == "A)") 0xFFEC4545 else 0xFFFFFFFF)
                )
        ) {
            Text(
                text = "A)",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Text(
                text = answersMap["A)"]!!,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
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
                    color = Color(if (correctAnswer == "B)") 0xFFEC4545 else 0xFFFFFFFF)
                )
        ) {
            Text(
                text = "B)",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Text(
                text = answersMap["B)"]!!,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
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
                    color = Color(if (correctAnswer == "C)") 0xFFEC4545 else 0xFFFFFFFF)
                )
        ) {
            Text(
                text = "C)",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Text(
                text = answersMap["C)"]!!,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        val context = LocalContext.current

        Text(
            text = "Zobacz źródło",
            color = Color(0xFF1040EC),
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .clickable {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(source)
                        )
                    )
                }
        )
    }
}

data class Question(
    val question: String,
    val answersMap: Map<String, String>,
    val correctAnswer: String,
    val source: String,
)