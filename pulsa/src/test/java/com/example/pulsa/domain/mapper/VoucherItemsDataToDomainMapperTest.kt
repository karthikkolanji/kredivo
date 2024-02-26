package com.example.pulsa.domain.mapper

import com.example.pulsa.data.datasource.repository.model.VoucherItemDataModel
import com.example.pulsa.domain.model.VoucherItemDomainModel
import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class VoucherItemsDataToDomainMapperTest(
    private val input: VoucherItemDataModel,
    private val expected: VoucherItemDomainModel
) {
    companion object {
        @JvmStatic
        @Parameters(name = "Given {0} When toData Then returns {1}")
        fun getParameters() =
            listOf(
                arrayOf(
                    VoucherItemDataModel(
                        endDate = "2024-02-03T00:00:00Z",
                        howToUse = "howToUse1",
                        imageUrl = "imageUrl1",
                        maxDiscount = 1500,
                        minTransactionAmount = 3000,
                        name = "name1",
                        percentage = 100,
                        startDate = "2024-02-02T00:00:00Z",
                        termsAndCondition = "termsAndCondition1",
                        usageCount = 1,
                        voucherCode = "usageCount1"
                    ),
                    VoucherItemDomainModel(
                        endDate = "2024-02-03T00:00:00Z",
                        maxDiscount = 1500,
                        minTransactionAmount = 3000,
                        name = "name1",
                        percentage = 100,
                        voucherCode = "usageCount1",
                        isVoucherApplicable = false
                    )
                ),
                arrayOf(
                    VoucherItemDataModel(
                        endDate = "2024-02-03T00:00:00Z",
                        howToUse = "howToUse2",
                        imageUrl = "imageUrl2",
                        maxDiscount = 2500,
                        minTransactionAmount = 4000,
                        name = "name2",
                        percentage = 200,
                        startDate = "2024-02-02T00:00:00Z",
                        termsAndCondition = "termsAndCondition2",
                        usageCount = 2,
                        voucherCode = "usageCount2"
                    ),
                    VoucherItemDomainModel(
                        endDate = "2024-02-03T00:00:00Z",
                        maxDiscount = 2500,
                        minTransactionAmount = 4000,
                        name = "name2",
                        percentage = 200,
                        voucherCode = "usageCount2",
                        isVoucherApplicable = false
                    )
                )
            )
    }

    private lateinit var classUnderTest: VoucherItemsDataToDomainMapper

    @Before
    fun setup() {
        classUnderTest = VoucherItemsDataToDomainMapper()
    }

    @Test
    fun `Given ProductResponseApiModel When toData Then returns PlansItemResponseDataModel`() {
        // When
        val actualResult = classUnderTest.toDomain(input)

        // Then
        Truth.assertThat(expected).isEqualTo(actualResult)
    }
}