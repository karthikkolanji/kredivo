package com.example.pulsa.domain.usecase

import com.example.pulsa.data.datasource.repository.TopUpRepository
import com.example.pulsa.domain.mapper.PaymentDetailsResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.ProductResponseDataToDomainMapper
import javax.inject.Inject

class TopUpUseCaseImp @Inject constructor(
    private val topUpRepository: TopUpRepository,
    private val productResponseDataToDomainMapper: ProductResponseDataToDomainMapper,
    private val paymentDetailsResponseDataToDomainMapper: PaymentDetailsResponseDataToDomainMapper
) : TopUpUseCase {
    override suspend fun getPlans() =
        topUpRepository.getPlans().products.map { productResponseDataToDomainMapper.toDomain(it) }

    override suspend fun makePayment() =
        paymentDetailsResponseDataToDomainMapper.toDomain(topUpRepository.makePayment())

}