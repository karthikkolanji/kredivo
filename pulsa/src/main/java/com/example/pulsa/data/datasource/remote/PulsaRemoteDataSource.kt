package com.example.pulsa.data.datasource.remote

import javax.inject.Inject

class PulsaRemoteDataSource @Inject constructor(private val pulsaApiService: PulsaApiService) {

    suspend fun get()=pulsaApiService.plans()
}