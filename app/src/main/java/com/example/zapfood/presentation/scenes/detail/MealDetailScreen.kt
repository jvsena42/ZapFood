package com.example.zapfood.presentation.scenes.detail

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.zapfood.data.model.response.Category

@Composable
fun MealDetailScreen(category: Category) {
    var pictureState by remember { mutableStateOf(MealPictureState.Normal) }
    val transition = updateTransition(targetState = pictureState, "")
    val imageSizeDP: Dp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val borderWidth: Dp by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")


    Column {
        Row {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(width = borderWidth, color = color)
            ) {
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
                pictureState = if (pictureState == MealPictureState.Normal) MealPictureState.Expanded else MealPictureState.Normal
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Change state of meal profile pitures")

        }
    }
}

enum class MealPictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 2.dp),
    Expanded(Color.Green, 200.dp, 4.dp)
}

object MealDetailDestination {
    const val TAG = "destination_meals_detail"
}