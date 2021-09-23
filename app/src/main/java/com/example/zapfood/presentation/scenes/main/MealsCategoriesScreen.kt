package com.example.zapfood.presentation.scenes.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zapfood.data.util.Resource

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val categories = viewModel.listCategories.value
    when(categories) {
        is Resource.Success-> {
            val list = categories.data?.categories?.toList().orEmpty()
            LazyColumn {
                items(list){category->
                    Text(text = category.category.toString())
                }
            }
        }
    }
}