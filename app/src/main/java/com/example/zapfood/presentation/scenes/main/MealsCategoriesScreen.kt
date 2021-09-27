package com.example.zapfood.presentation.scenes.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zapfood.data.util.Resource
import com.example.zapfood.presentation.ui.theme.ZapFoodTheme

@Composable
@Preview
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val categories = viewModel.listCategories.value
    when(categories) {
        is Resource.Success-> {
            val list = categories.data?.categories?.toList().orEmpty()
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(list){category->
                    MealCategory(category)
                }
            }
        }
    }
}