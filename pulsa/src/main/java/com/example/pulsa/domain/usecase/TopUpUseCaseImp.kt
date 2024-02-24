package com.example.pulsa.domain.usecase

import com.example.pulsa.data.datasource.repository.TopUpRepository
import com.example.pulsa.domain.mapper.PaymentDetailsResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.ProductResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.VoucherResponseDataToDomainMapper
import javax.inject.Inject

class TopUpUseCaseImp @Inject constructor(
    private val topUpRepository: TopUpRepository,
    private val productResponseDataToDomainMapper: ProductResponseDataToDomainMapper,
    private val paymentDetailsResponseDataToDomainMapper: PaymentDetailsResponseDataToDomainMapper,
    private val voucherResponseDataToDomainMapper: VoucherResponseDataToDomainMapper
) : TopUpUseCase {
    override suspend fun getPlans() =
        topUpRepository.getPlans().products.map { productResponseDataToDomainMapper.toDomain(it) }

    override suspend fun makePayment() =
        paymentDetailsResponseDataToDomainMapper.toDomain(topUpRepository.makePayment())

    override suspend fun getVoucher() =
        voucherResponseDataToDomainMapper.toDomain(topUpRepository.getVoucher())

}