package com.ajailani.findyourcatscmp.data.repository

import com.ajailani.findyourcatscmp.util.ApiResult
import com.ajailani.findyourcatscmp.data.model.Cat
import com.ajailani.findyourcatscmp.data.remote.data_source.CatRemoteDataSource
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.http.HttpStatusCode.Companion.OK
import kotlinx.coroutines.flow.flow

class CatRepository(private val remoteDataSource: CatRemoteDataSource) {
    fun getCats() = flow {
        val response = remoteDataSource.getCats()

        when (response.status) {
            OK -> {
                val responseBody = response.body<List<Cat>>()
                emit(ApiResult.Success(responseBody))
            }

            InternalServerError -> emit(ApiResult.Error("Server error"))

            else -> emit(ApiResult.Error("Sorry, something wrong happened"))
        }
    }

    fun getCatDetail(id: String) = flow {
        val response = remoteDataSource.getCatDetail(id)

        when (response.status) {
            OK -> {
                val responseBody = response.body<Cat>()
                emit(ApiResult.Success(responseBody))
            }

            InternalServerError -> emit(ApiResult.Error("Server error"))

            else -> emit(ApiResult.Error("Sorry, something wrong happened"))
        }
    }
}