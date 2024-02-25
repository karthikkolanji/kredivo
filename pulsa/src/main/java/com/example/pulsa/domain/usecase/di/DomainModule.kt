package com.example.pulsa.domain.usecase.di

import com.example.pulsa.data.datasource.repository.TopUpRepository
import com.example.pulsa.domain.mapper.PaymentDetailsResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.PlansResponseDataToDomainMapper
import com.example.pulsa.domain.mapper.VoucherResponseDataToDomainMapper
import com.example.pulsa.domain.usecase.TopUpUseCase
import com.example.pulsa.domain.usecase.TopUpUseCaseImp
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
        topUpRepository: TopUpRepository,
        plansResponseDataToDomainMapper: PlansResponseDataToDomainMapper,
        paymentDetailsResponseDataToDomainMapper: PaymentDetailsResponseDataToDomainMapper,
        voucherResponseDataToDomainMapper: VoucherResponseDataToDomainMapper
    ): TopUpUseCase {
        return TopUpUseCaseImp(
            topUpRepository,
            plansResponseDataToDomainMapper,
            paymentDetailsResponseDataToDomainMapper,
            voucherResponseDataToDomainMapper
        )
    }
}
