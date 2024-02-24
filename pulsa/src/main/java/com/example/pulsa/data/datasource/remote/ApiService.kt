package com.example.pulsa.data.datasource.remote

import com.example.pulsa.data.datasource.remote.model.PaymentDetailsResponseApiModel
import com.example.pulsa.data.datasource.remote.model.PulsaPlansResponseApiModel
import com.example.pulsa.data.datasource.remote.model.VoucherResponseApiModel
import retrofit2.http.GET

interface ApiService {
    @GET("21a9f0c5-34bc-445c-85fe-d020c5b95df3")
    suspend fun getPlans():PulsaPlansResponseApiModel

    @GET("cb3028bb-f2e1-4c94-914f-fbb3dca3f346")
    suspend fun makePayment():PaymentDetailsResponseApiModel

    @GET("df3a3b2c-9b6c-419d-bfc6-436d736e9664")
    suspend fun getVoucher():VoucherResponseApiModel
}