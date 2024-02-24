package com.example.pulsa.data.datasource.repository

import com.example.pulsa.data.datasource.remote.TopUpRemoteDataSource
import com.example.pulsa.data.datasource.repository.mapper.PaymentDetailsResponseApiToDataMapper
import com.example.pulsa.data.datasource.repository.mapper.PulsaPlansResponseApiToDataMapper
import com.example.pulsa.data.datasource.repository.mapper.VoucherResponseApiToDataMapper
import javax.inject.Inject

class TopUpRepositoryImp @Inject constructor(
    private val topUpRemoteDataSource: TopUpRemoteDataSource,
    private val pulsaPlansResponseApiToDataMapper: PulsaPlansResponseApiToDataMapper,
    private val paymentDetailsResponseApiToDataMapper: PaymentDetailsResponseApiToDataMapper,
    private val voucherResponseApiToDataMapper: VoucherResponseApiToDataMapper
) : TopUpRepository {
    override suspend fun getPlans() =
        pulsaPlansResponseApiToDataMapper.toData(topUpRemoteDataSource.getPulsaPlans())

    override suspend fun makePayment() =
        paymentDetailsResponseApiToDataMapper.toData(topUpRemoteDataSource.makePayment())

    override suspend fun getVoucher() =
        voucherResponseApiToDataMapper.toData(topUpRemoteDataSource.getVoucher())
}