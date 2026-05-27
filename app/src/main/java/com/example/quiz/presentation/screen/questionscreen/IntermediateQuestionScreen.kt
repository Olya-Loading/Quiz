package com.example.quiz.presentation.screen.questionscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.data.model.CardInfo
import com.example.quiz.presentation.composables.ButtonAddParagraph
import com.example.quiz.presentation.composables.ButtonCheck
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleQuizBackground
import com.example.quiz.ui.theme.QuizTheme
import java.nio.file.WatchEvent

@Composable
fun IntermediateQuestionScreen(
    modifier: Modifier = Modifier,
    type: String,
    navHostController: NavHostController
) {
    IntermediateQuestionScreenContent(Modifier, type, navHostController, listOf(CardInfo("", "")))
}

@Composable
fun IntermediateQuestionScreenContent(
    modifier: Modifier = Modifier, type: String,
    navHostController: NavHostController,
    list: List<CardInfo>
) {
    SimpleQuizBackground(Modifier, "        Вопросы", type, navHostController)

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 200.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = list) { item ->
                CardWork(Modifier, item.title, item.description, {}, true)
            }
            item {
                Row(
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ButtonAddParagraph() { }
                    ButtonCheck() { }
                }
            }
        }
    }
}

@Preview
@Composable
private fun IntermediateQuestionScreenContentPreview() {
    QuizTheme {
        IntermediateQuestionScreenContent(
            Modifier,
            "quiz",
            rememberNavController(),
            listOf(CardInfo("", ""))
        )
    }
}