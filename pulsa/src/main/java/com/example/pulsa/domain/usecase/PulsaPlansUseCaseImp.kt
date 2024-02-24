package com.example.pulsa.domain.usecase

import com.example.pulsa.data.datasource.repository.PulsaRepository
import com.example.pulsa.domain.mapper.ProductResponseDataToDomainMapper
import javax.inject.Inject

class PulsaPlansUseCaseImp @Inject constructor(
    private val pulsaRepository: PulsaRepository,
    private val productResponseDataToDomainMapper: ProductResponseDataToDomainMapper
) : PulsaPlansUseCase {
    override suspend fun get() =
        pulsaRepository.get().products.map { productResponseDataToDomainMapper.toDomain(it) }

}