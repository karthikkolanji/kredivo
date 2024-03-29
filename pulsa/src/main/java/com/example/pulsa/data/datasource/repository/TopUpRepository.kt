package com.example.pulsa.data.datasource.repository

import com.example.pulsa.data.datasource.repository.model.PaymentDetailsResponseDataModel
import com.example.pulsa.data.datasource.repository.model.PulsaPlansResponseDataModel
import com.example.pulsa.data.datasource.repository.model.VoucherResponseDataModel

interface TopUpRepository {
    suspend fun getPlans(): PulsaPlansResponseDataModel
    suspend fun makePayment(): PaymentDetailsResponseDataModel
    suspend fun getVoucher(): VoucherResponseDataModel
}