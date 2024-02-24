package com.example.pulsa.domain.usecase

import com.example.pulsa.domain.model.ProductResponseDomainModel

interface PulsaPlansUseCase {
    suspend fun get():List<ProductResponseDomainModel>
}