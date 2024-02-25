package com.example.pulsa.domain.usecase

import com.example.pulsa.domain.model.PaymentDetailsResponseDomainModel
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.domain.model.VoucherResponseDomainModel

interface TopUpUseCase {
    suspend fun getPlans(): List<PlansItemResponseDomainModel>
    suspend fun makePayment(): PaymentDetailsResponseDomainModel
    suspend fun getVoucher(): VoucherResponseDomainModel
}