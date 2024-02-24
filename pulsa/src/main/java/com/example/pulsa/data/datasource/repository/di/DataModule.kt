package com.example.pulsa.data.datasource.repository.di

import com.example.pulsa.data.datasource.remote.ApiService
import com.example.pulsa.data.datasource.remote.TopUpRemoteDataSource
import com.example.pulsa.data.datasource.repository.TopUpRepository
import com.example.pulsa.data.datasource.repository.TopUpRepositoryImp
import com.example.pulsa.data.datasource.repository.mapper.PaymentDetailsResponseApiToDataMapper
import com.example.pulsa.data.datasource.repository.mapper.PulsaPlansResponseApiToDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        topUpRemoteDataSource: TopUpRemoteDataSource,
        pulsaPlansResponseApiToDataMapper: PulsaPlansResponseApiToDataMapper,
        paymentDetailsResponseApiToDataMapper: PaymentDetailsResponseApiToDataMapper
    ): TopUpRepository {
        return TopUpRepositoryImp(
            topUpRemoteDataSource,
            pulsaPlansResponseApiToDataMapper,
            paymentDetailsResponseApiToDataMapper
        )
    }
}
