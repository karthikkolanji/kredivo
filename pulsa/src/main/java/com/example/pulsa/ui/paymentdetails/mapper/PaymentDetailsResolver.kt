package com.example.pulsa.ui.paymentdetails.mapper

import com.example.pulsa.domain.model.PaymentDetailsResponseDomainModel
import com.example.pulsa.ui.paymentdetails.model.PaymentDetailsResponseUiModel
import com.example.pulsa.ui.plans.model.PlansItemResponseUiModel
import javax.inject.Inject

class PaymentDetailsResolver @Inject constructor() {
    fun resolve(
        plan: PlansItemResponseUiModel,
        paymentDetails: PaymentDetailsResponseDomainModel
    ) = PaymentDetailsResponseUiModel(
        orderId =paymentDetails.orderId,
        productName =plan.productName,
        status =paymentDetails.status,
        mobileNumber =plan.mobileNumber,
        subtotalAmount =plan.rechargeAmount,
        rechargeAmount = plan.rechargeAmount,
        payIn30DaysAmount =paymentDetails.checkOutAmount
    )
}