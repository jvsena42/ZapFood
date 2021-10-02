package com.example.zapfood.presentation.scenes.detail

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.zapfood.data.model.response.Category

@Composable
fun MealDetailScreen(category: Category) {
    var isExpanded by remember { mutableStateOf(false) }
    val imageSizeDP: Dp by animateDpAsState(targetValue = if (isExpanded) 200.dp else 100.dp)

    Column {
        Row {
            Card {
                Image(
                    painter = rememberImagePainter(category.categoryThumb, builder = {
                        transformations(CircleCropTransformation())
                    }),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSizeDP)
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Text(
                text = category.category ?: "",
                modifier = Modifier.padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(
            onClick = {
                isExpanded = !isExpanded
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Change state of meal profile pitures")

        }
    }
}

object MealDetailDestination {
    const val TAG = "destination_meals_detail"
}