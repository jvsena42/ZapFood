package com.example.zapfood.presentation.scenes.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zapfood.data.util.Resource

@Composable
fun MealsCategoriesScreen(viewModel: MealsCategoriesViewModel = hiltViewModel() ,navigationCallback: (String) -> Unit) {
    viewModel.getCategories()

    val categories = viewModel.listCategories.value
    when(categories) {
        is Resource.Success -> {
            val list = categories.data?.categories?.toList().orEmpty()
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(list){category->
                    MealCategory(category, navigationCallback)
                }
            }
        }
    }
}

object MealsCategoryDestination{
    const val TAG = "destination_meals_category"
}