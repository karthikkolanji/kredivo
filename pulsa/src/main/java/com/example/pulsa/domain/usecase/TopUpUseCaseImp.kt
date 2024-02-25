package com.example.pulsa.domain.usecase

import com.example.pulsa.data.datasource.repository.TopUpRepository
import com.example.pulsa.domain.mapper.PaymentDetailsResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.PlansResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.VoucherResponseDataToDomainMapper
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

    override suspend fun getVoucher() =
        voucherResponseDataToDomainMapper.toDomain(topUpRepository.getVoucher())

}