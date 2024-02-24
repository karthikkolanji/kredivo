package com.example.pulsa.data.datasource.remote

import com.example.pulsa.data.datasource.remote.model.PulsaPlansResponseApiModel
import retrofit2.http.GET

interface PulsaApiService {
    @GET("21a9f0c5-34bc-445c-85fe-d020c5b95df3")
    suspend fun plans():PulsaPlansResponseApiModel
}