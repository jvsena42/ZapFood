package com.example.zapfood.domain.usecase

import com.example.zapfood.data.model.response.GetCategoriesResponse
import com.example.zapfood.data.util.Resource
import com.example.zapfood.domain.repository.Repository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor (
    private val repository: Repository
    ) {
    suspend fun execute(): Resource<GetCategoriesResponse>{
        return repository.getCategories()
    }
}