package com.example.pulsa.domain.usecase

import com.example.pulsa.domain.model.PaymentDetailsResponseDomainModel
import com.example.pulsa.domain.model.ProductResponseDomainModel
import com.example.pulsa.domain.model.VoucherResponseDomainModel

interface TopUpUseCase {
    suspend fun getPlans(): List<ProductResponseDomainModel>
    suspend fun makePayment(): PaymentDetailsResponseDomainModel
    suspend fun getVoucher(): VoucherResponseDomainModel
}