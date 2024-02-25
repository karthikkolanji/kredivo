package com.example.pulsa.ui.plans.mapper

import com.example.core.mapper.DomainToUiMapper
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.ui.plans.model.PlansResponseUiModel
import javax.inject.Inject

class PlansResponseDomainToUiMapper @Inject constructor(private val plansItemResponseDomainToUiMapper: PlansItemResponseDomainToUiMapper) :
    DomainToUiMapper<List<PlansItemResponseDomainModel>, PlansResponseUiModel>() {
    override fun map(input: List<PlansItemResponseDomainModel>) = PlansResponseUiModel(
        item = input.map { plansItemResponseDomainToUiMapper.toUi(it) }
    )
}