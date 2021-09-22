package com.example.zapfood.data.model.response


import com.google.gson.annotations.SerializedName

data class GetCategoriesResponse(
    @SerializedName("categories")
    val categories: List<Category>?
)