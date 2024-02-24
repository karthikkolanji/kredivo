package com.example.pulsa.data.datasource.repository

import com.example.pulsa.data.datasource.remote.TopUpRemoteDataSource
import com.example.pulsa.data.datasource.repository.mapper.PaymentDetailsResponseApiToDataMapper
import com.example.pulsa.data.datasource.repository.mapper.PulsaPlansResponseApiToDataMapper
import javax.inject.Inject

class TopUpRepositoryImp @Inject constructor(
    private val topUpRemoteDataSource: TopUpRemoteDataSource,
    private val pulsaPlansResponseApiToDataMapper: PulsaPlansResponseApiToDataMapper,
    private val paymentDetailsResponseApiToDataMapper: PaymentDetailsResponseApiToDataMapper
) : TopUpRepository {
    override suspend fun getPlans() =
        pulsaPlansResponseApiToDataMapper.toData(topUpRemoteDataSource.getPulsaPlans())

    override suspend fun makePayment() =
        paymentDetailsResponseApiToDataMapper.toData(topUpRemoteDataSource.makePayment())
}