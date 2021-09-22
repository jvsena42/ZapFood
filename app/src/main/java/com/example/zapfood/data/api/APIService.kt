package com.example.zapfood.data.api

import com.example.zapfood.data.model.response.GetCategoriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("categories.php")
    suspend fun getCryptoValues(): Response<GetCategoriesResponse>
}