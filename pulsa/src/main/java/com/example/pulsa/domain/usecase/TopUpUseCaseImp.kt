package com.example.pulsa.domain.usecase

import com.example.pulsa.data.datasource.repository.TopUpRepository
import com.example.pulsa.domain.mapper.PaymentDetailsResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.PlansResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.VoucherResponseDataToDomainMapper
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.domain.model.VoucherItemDomainModel
import timber.log.Timber
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

}