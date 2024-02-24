package com.example.pulsa.data.datasource.repository.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.pulsa.data.datasource.remote.model.PaymentDetailsResponseApiModel
import com.example.pulsa.data.datasource.repository.model.PaymentDetailsResponseDataModel
import javax.inject.Inject

class PaymentDetailsResponseApiToDataMapper @Inject constructor() :
    ApiToDataMapper<PaymentDetailsResponseApiModel, PaymentDetailsResponseDataModel>() {
    override fun map(input: PaymentDetailsResponseApiModel) = PaymentDetailsResponseDataModel(
        orderId = input.transaction_context.order_id,
        merchantLogoUrl = input.transaction_context.merchant_details.logo_url,
        merchantName = input.transaction_context.merchant_details.name,
    )
}