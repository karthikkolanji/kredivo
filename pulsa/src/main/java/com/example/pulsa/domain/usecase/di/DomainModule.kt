package com.example.pulsa.domain.usecase.di

import com.example.pulsa.data.datasource.repository.PulsaRepository
import com.example.pulsa.domain.mapper.ProductResponseDataToDomainMapper
import com.example.pulsa.domain.usecase.PulsaPlansUseCase
import com.example.pulsa.domain.usecase.PulsaPlansUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Singleton
    fun provideRepository(
        pulsaRepository: PulsaRepository,
        productResponseDataToDomainMapper: ProductResponseDataToDomainMapper
    ): PulsaPlansUseCase {
        return PulsaPlansUseCaseImp(pulsaRepository, productResponseDataToDomainMapper)
    }
}
