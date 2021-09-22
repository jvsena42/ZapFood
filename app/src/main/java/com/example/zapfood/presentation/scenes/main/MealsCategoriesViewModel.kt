package com.example.zapfood.presentation.scenes.main

import androidx.lifecycle.ViewModel
import com.example.zapfood.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor (
    useCase: GetCategoriesUseCase
) : ViewModel() {
}