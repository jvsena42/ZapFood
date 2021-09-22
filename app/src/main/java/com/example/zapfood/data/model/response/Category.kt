package com.example.zapfood.data.model.response


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val id: String?,
    @SerializedName("strCategory")
    val category: String?,
    @SerializedName("strCategoryDescription")
    val categoryDescription: String?,
    @SerializedName("strCategoryThumb")
    val categoryThumb: String?
)