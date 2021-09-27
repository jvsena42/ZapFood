package com.example.zapfood.presentation.scenes.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.zapfood.data.model.response.Category

@ExperimentalCoilApi
@Composable
fun MealCategory(category: Category) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            Image(
                painter = rememberImagePainter(category.categoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)) {
                Text(text = category.category ?: "",
                style = MaterialTheme.typography.h6)
            }
        }
    }
}