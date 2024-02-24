package com.example.pulsa.domain.mapper

import com.example.core.mapper.DataToDomainMapper
import com.example.pulsa.data.datasource.repository.model.PaymentDetailsResponseDataModel
import com.example.pulsa.domain.model.PaymentDetailsResponseDomainModel
import javax.inject.Inject

class PaymentDetailsResponseDataToDomainMapper @Inject constructor() :
    DataToDomainMapper<PaymentDetailsResponseDataModel, PaymentDetailsResponseDomainModel>() {
    override fun map(input: PaymentDetailsResponseDataModel) = PaymentDetailsResponseDomainModel(
        orderId = input.orderId,
        merchantName = input.merchantName,
        merchantLogoUrl = input.merchantLogoUrl
    )
}