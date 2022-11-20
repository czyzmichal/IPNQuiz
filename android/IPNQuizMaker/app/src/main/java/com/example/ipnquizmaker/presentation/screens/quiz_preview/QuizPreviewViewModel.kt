package com.example.ipnquizmaker.presentation.screens.quiz_preview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizPreviewViewModel : ViewModel() {
    var state by mutableStateOf(emptyList<Question>())

    init {
        viewModelScope.launch {
            delay(5000)
            state = listOf(
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
            )
        }
    }
}

data class Question(
    val question: String,
    val answersMap: Map<String, String>,
    val correctAnswer: String,
    val source: String,
)