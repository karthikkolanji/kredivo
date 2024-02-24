package com.example.pulsa.domain.usecase

import com.example.pulsa.domain.model.PaymentDetailsResponseDomainModel
import com.example.pulsa.domain.model.ProductResponseDomainModel

interface TopUpUseCase {
    suspend fun getPlans(): List<ProductResponseDomainModel>
    suspend fun makePayment(): PaymentDetailsResponseDomainModel
}