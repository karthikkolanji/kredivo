package com.example.pulsa.ui.plans.model

import java.math.BigDecimal

data class PlansResponseUiModel(
    val item: List<PlansItemResponseUiModel>
)

data class PlansItemResponseUiModel(
    val productCode: String,
    val productName: String,
    val rechargeAmount: BigDecimal,
    val talkTimeAmount: BigDecimal
)
