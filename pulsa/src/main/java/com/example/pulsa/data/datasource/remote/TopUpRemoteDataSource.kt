package com.example.pulsa.data.datasource.remote

import javax.inject.Inject

class TopUpRemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getPulsaPlans()=apiService.getPlans()

    suspend fun makePayment()=apiService.makePayment()
}