package com.example.zapfood.presentation.scenes.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.zapfood.data.model.response.Category

@Composable
fun MealDetailScreen(category: Category){
    Column {
        Row {
            Card {
                Image(
                    painter = rememberImagePainter(category.categoryThumb, builder = {
                        transformations(CircleCropTransformation())
                    }),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Text(category.category ?: "")
        }
        Button(onClick = {}){
            Text("Change state of meal profile pitures")

        }
    }
}

object MealDetailDestination{
    const val TAG = "destination_meals_detail"
}