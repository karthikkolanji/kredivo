package com.example.pulsa.data.datasource.repository.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.pulsa.data.datasource.remote.model.VoucherItemApiModel
import com.example.pulsa.data.datasource.repository.model.VoucherItemDataModel
import javax.inject.Inject

class VoucherItemsApiToDataMapper @Inject constructor() :
    ApiToDataMapper<VoucherItemApiModel, VoucherItemDataModel>() {
    override fun map(input: VoucherItemApiModel) = VoucherItemDataModel(
        endDate = input.end_date,
        howToUse = input.how_to_use,
        imageUrl = input.image_url,
        maxDiscount = input.max_discount,
        minTransactionAmount = input.min_transaction_amount,
        name = input.name,
        percentage = input.percentage,
        startDate = input.start_date,
        termsAndCondition = input.terms_and_condition,
        usageCount = input.usage_count,
        voucherCode = input.voucher_code
    )
}