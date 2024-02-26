package com.example.pulsa.domain.usecase

import com.example.pulsa.data.datasource.repository.TopUpRepository
import com.example.pulsa.domain.mapper.PaymentDetailsResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.PlansResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.VoucherResponseDataToDomainMapper
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.domain.model.PurchaseRequestDomainModel
import com.example.pulsa.domain.model.VoucherItemDomainModel
import javax.inject.Inject

class TopUpUseCaseImp @Inject constructor(
    private val topUpRepository: TopUpRepository,
    private val plansResponseDataToDomainMapper: PlansResponseDataToDomainMapper,
    private val paymentDetailsResponseDataToDomainMapper: PaymentDetailsResponseDataToDomainMapper,
    private val voucherResponseDataToDomainMapper: VoucherResponseDataToDomainMapper
) : TopUpUseCase {
    override suspend fun getPlans() =
        topUpRepository.getPlans().plans.map { plansResponseDataToDomainMapper.toDomain(it) }

    override suspend fun makePayment() =
        paymentDetailsResponseDataToDomainMapper.toDomain(topUpRepository.makePayment())

    override suspend fun getVoucher(plan: PlansItemResponseDomainModel): List<VoucherItemDomainModel> {
        val voucher = voucherResponseDataToDomainMapper.toDomain(topUpRepository.getVoucher())
        val rechargeAmount = plan.price
        return voucher.voucherItems.map { item ->
            if (rechargeAmount >= item.minTransactionAmount) {
                item.copy(isVoucherApplicable = true)
            } else {
                item.copy(isVoucherApplicable = false)
            }
        }

    }

    override suspend fun applyVoucher(
        plans: PlansItemResponseDomainModel,
        voucher: VoucherItemDomainModel?
    ): PurchaseRequestDomainModel {
        return if (voucher != null) {
            PurchaseRequestDomainModel(
                voucherApplied = true,
                voucherCode = voucher.voucherCode,
                rechargeAmount = plans.price,
                discountAmount = plans.price - voucher.maxDiscount,
                maxDiscount = voucher.maxDiscount,
                percentage = voucher.percentage
            )
        } else {
            PurchaseRequestDomainModel(
                voucherApplied = false,
                rechargeAmount = plans.price,
                maxDiscount = 0,
                percentage = 0
            )
        }
    }

}