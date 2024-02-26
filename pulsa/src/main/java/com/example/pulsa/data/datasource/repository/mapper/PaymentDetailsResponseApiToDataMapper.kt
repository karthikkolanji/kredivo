package com.example.pulsa.data.datasource.repository.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.pulsa.data.datasource.remote.model.PaymentDetailsResponseApiModel
import com.example.pulsa.data.datasource.repository.model.PaymentDetailsResponseDataModel
import javax.inject.Inject

class PaymentDetailsResponseApiToDataMapper @Inject constructor() :
    ApiToDataMapper<PaymentDetailsResponseApiModel, PaymentDetailsResponseDataModel>() {
    override fun map(input: PaymentDetailsResponseApiModel) = PaymentDetailsResponseDataModel(
        orderId = input.transaction_context.order_id,
        status = input.status,
        checkoutAmount = input.transaction_context.checkout_amount.toInt()
    )
}