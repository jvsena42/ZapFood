package com.example.zapfood.presentation.scenes.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.zapfood.data.model.response.Category

class MealDetailsViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    var mealState = mutableStateOf<Category?>(null)


    init {
        val categoryId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = Category("","","","")
    }
}