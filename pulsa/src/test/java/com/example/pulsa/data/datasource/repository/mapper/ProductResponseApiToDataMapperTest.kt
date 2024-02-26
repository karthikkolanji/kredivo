package com.example.pulsa.data.datasource.repository.mapper

import com.example.pulsa.data.datasource.remote.model.ProductResponseApiModel
import com.example.pulsa.data.datasource.repository.model.PlansItemResponseDataModel
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class ProductResponseApiToDataMapperTest(
    private val input: ProductResponseApiModel,
    private val expected: PlansItemResponseDataModel
) {
    companion object {
        @JvmStatic
        @Parameters(name = "Given {0} When toData Then returns {1}")
        fun getParameters() =
            listOf(
                arrayOf(
                    ProductResponseApiModel(
                        bill_type = "mobile1",
                        description = "description1",
                        label = "label1",
                        nominal = "1000",
                        operator = "operator1",
                        price = "1500",
                        product_code = "productCode1",
                        sequence = 1
                    ),
                    PlansItemResponseDataModel(
                        billType = "mobile1",
                        description = "description1",
                        label = "label1",
                        nominal = "1000",
                        operator = "operator1",
                        price = "1500",
                        productCode = "productCode1",
                        sequence = 1
                    )
                ),
                arrayOf(
                    ProductResponseApiModel(
                        bill_type = "mobile2",
                        description = "description2",
                        label = "label2",
                        nominal = "2000",
                        operator = "operator2",
                        price = "2500",
                        product_code = "productCode2",
                        sequence = 2
                    ),
                    PlansItemResponseDataModel(
                        billType = "mobile2",
                        description = "description2",
                        label = "label2",
                        nominal = "2000",
                        operator = "operator2",
                        price = "2500",
                        productCode = "productCode2",
                        sequence = 2
                    )
                )
            )
    }

    private lateinit var classUnderTest: ProductResponseApiToDataMapper
    @Before
    fun setup() {
        classUnderTest = ProductResponseApiToDataMapper()
    }

    @Test
    fun `Given ProductResponseApiModel When toData Then returns PlansItemResponseDataModel`() {
        // When
        val actualResult = classUnderTest.toData(input)

        // Then
        Truth.assertThat(expected).isEqualTo(actualResult)
    }
}