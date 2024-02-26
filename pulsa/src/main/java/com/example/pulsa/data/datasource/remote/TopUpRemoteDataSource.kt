package com.example.pulsa.data.datasource.remote

import com.example.core.di.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TopUpRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    private val dispatcherProvider: DispatcherProvider
) {
    suspend fun getPulsaPlans() = withContext(dispatcherProvider.io()) { apiService.getPlans() }
    suspend fun makePayment() = withContext(dispatcherProvider.io()) { apiService.makePayment() }
    suspend fun getVoucher() = withContext(dispatcherProvider.io()) { apiService.getVoucher() }
}