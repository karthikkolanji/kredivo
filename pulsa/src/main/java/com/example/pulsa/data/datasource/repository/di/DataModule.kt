package com.example.pulsa.data.datasource.repository.di

import com.example.pulsa.data.datasource.remote.PulsaApiService
import com.example.pulsa.data.datasource.remote.PulsaRemoteDataSource
import com.example.pulsa.data.datasource.repository.PulsaRepository
import com.example.pulsa.data.datasource.repository.PulsaRepositoryImp
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
    fun provideApiService(retrofit: Retrofit): PulsaApiService {
        return retrofit.create(PulsaApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        pulsaRemoteDataSource: PulsaRemoteDataSource,
        pulsaPlansResponseApiToDataMapper: PulsaPlansResponseApiToDataMapper
    ): PulsaRepository {
        return PulsaRepositoryImp(pulsaRemoteDataSource, pulsaPlansResponseApiToDataMapper)
    }
}
