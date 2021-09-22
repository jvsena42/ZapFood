package com.example.zapfood.data.model.response

import com.google.gson.annotations.SerializedName

data class ErrorModel(
    @SerializedName("message")
    val error: String? = ""
)