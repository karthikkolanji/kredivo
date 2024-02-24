package com.example.pulsa.data.datasource.remote

import com.example.pulsa.data.datasource.remote.model.PaymentDetailsResponseApiModel
import com.example.pulsa.data.datasource.remote.model.PulsaPlansResponseApiModel
import retrofit2.http.GET

interface ApiService {
    @GET("21a9f0c5-34bc-445c-85fe-d020c5b95df3")
    suspend fun getPlans():PulsaPlansResponseApiModel

    @GET("cb3028bb-f2e1-4c94-914f-fbb3dca3f346")
    suspend fun makePayment():PaymentDetailsResponseApiModel
}