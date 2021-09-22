package com.example.zapfood.domain.repository

import com.example.zapfood.data.model.response.GetCategoriesResponse
import com.example.zapfood.data.util.Resource

interface Repository {
    suspend fun getCategories(): Resource<GetCategoriesResponse>
}