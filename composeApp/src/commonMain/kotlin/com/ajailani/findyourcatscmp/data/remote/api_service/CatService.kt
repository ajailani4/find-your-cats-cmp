package com.ajailani.findyourcatscmp.data.remote.api_service

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class CatService(private val httpClient: HttpClient) {
    suspend fun getCats() = httpClient.get("cats")

    suspend fun getCatDetail(id: String) = httpClient.get("cats/$id")
}