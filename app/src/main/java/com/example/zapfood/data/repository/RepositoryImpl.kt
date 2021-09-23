package com.example.zapfood.data.repository

import com.example.zapfood.data.model.response.ErrorModel
import com.example.zapfood.data.model.response.GetCategoriesResponse
import com.example.zapfood.data.repository.datasource.RemoteDataSource
import com.example.zapfood.data.util.Resource
import com.example.zapfood.domain.repository.Repository
import com.google.gson.Gson
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val remoteDataSource: RemoteDataSource
    ):Repository {
    override suspend fun getCategories(): Resource<GetCategoriesResponse> {
        return responseToResource(remoteDataSource.getCategories())
    }

    private fun <T>responseToResource(response: Response<T>): Resource<T> {
        try {
            if (response.isSuccessful){
                response.body()?.let {result->
                    return Resource.Success(result)
                }
            }
            val message = getErrorMessage(response)
            return Resource.Error(message)
        }catch (e:Exception) {
            return Resource.Error(e.message.toString())
        }
    }

    private fun <T> getErrorMessage(response: Response<T>): String {
        var message = ""
        message = try {
            Gson().fromJson(response.errorBody()?.string(), ErrorModel::class.java).error.toString()
        } catch (e: Exception) {
            e.message.toString()
        }
        return message
    }

}