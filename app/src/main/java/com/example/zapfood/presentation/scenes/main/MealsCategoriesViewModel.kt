package com.example.zapfood.presentation.scenes.main

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zapfood.data.model.response.GetCategoriesResponse
import com.example.zapfood.data.util.Resource
import com.example.zapfood.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor (
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    lateinit var listCategories: MutableState<Resource<GetCategoriesResponse>>

    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch(Dispatchers.IO) {
        listCategories.value = Resource.Loading()
        val apiResult = getCategoriesUseCase.execute()
        listCategories.value = apiResult
    }
}