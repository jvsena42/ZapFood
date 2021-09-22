package com.example.zapfood.data.repository.datasource

import com.example.zapfood.data.model.response.GetCategoriesResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getCategories(): Response<GetCategoriesResponse>
}