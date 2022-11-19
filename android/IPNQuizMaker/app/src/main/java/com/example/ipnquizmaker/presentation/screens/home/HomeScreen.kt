package com.example.ipnquizmaker.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ipnquizmaker.R

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(color = Color(0xFFEC4545))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
                .background(color = Color(0xFFF3F4F5))
                .height(92.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "",
                modifier = Modifier.size(size = 56.dp)
            )

            Text(
                text = "Pan nauczyciel Jan Kowalski",
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFEC4545)
                )
                .height(56.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "",
                modifier = Modifier.size(size = 32.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Utwórz nowy quiz",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(id = R.drawable.ic_forward_arrow),
                    contentDescription = "",
                    modifier = Modifier.size(width = 6.dp, height = 16.dp)
                )
            }
        }

        Text(
            text = "Moje quizy:",
            fontSize = 14.sp,
            modifier = Modifier.padding(all = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            items(count = 4) {
                QuizCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun QuizCard(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(56.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF3F4F5)
            )
    ) {
        Spacer(modifier = Modifier.width(16.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_previous),
            contentDescription = "",
            modifier = Modifier.size(size = 32.dp)
        )

        Text(
            text = "Quiz o powstaniu warszawskim",
            fontSize = 14.sp,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        )

        IconButton(onClick = {}) {
            Image(
                painter = painterResource(id = R.drawable.ic_download_pdf),
                contentDescription = "",
                modifier = Modifier.size(size = 28.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
    }
}