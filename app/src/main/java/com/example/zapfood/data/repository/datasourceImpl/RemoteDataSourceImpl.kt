package com.example.zapfood.data.repository.datasourceImpl

import com.example.zapfood.data.api.APIService
import com.example.zapfood.data.model.response.GetCategoriesResponse
import com.example.zapfood.data.repository.datasource.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor (
    private val apiService: APIService
): RemoteDataSource {
    override suspend fun getCategories(): Response<GetCategoriesResponse> {
        return apiService.getCryptoValues()
    }
}