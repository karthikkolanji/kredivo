package com.example.pulsa.domain.usecase

import com.example.pulsa.domain.model.PaymentDetailsResponseDomainModel
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.domain.model.PurchaseRequestDomainModel
import com.example.pulsa.domain.model.VoucherItemDomainModel

interface TopUpUseCase {
    suspend fun getPlans(): List<PlansItemResponseDomainModel>
    suspend fun makePayment(): PaymentDetailsResponseDomainModel
    suspend fun getVoucher(plan: PlansItemResponseDomainModel): List<VoucherItemDomainModel>

    suspend fun applyVoucher(plans: PlansItemResponseDomainModel, voucher: VoucherItemDomainModel?): PurchaseRequestDomainModel

}