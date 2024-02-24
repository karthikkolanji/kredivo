package com.example.pulsa.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.core.extensions.viewLifecycleScoped
import com.example.core.utils.UiState.Error
import com.example.core.utils.UiState.Loading
import com.example.core.utils.UiState.Success
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentPulsaPlansBinding
import com.example.pulsa.domain.model.ProductResponseDomainModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class PulsaPlansFragment : Fragment(R.layout.fragment_pulsa_plans) {

    private val binding: FragmentPulsaPlansBinding by viewLifecycleScoped(
        FragmentPulsaPlansBinding::bind
    )
    private val viewModel: PulsaPlansViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerPlans()
    }

    private fun observerPlans() {
        lifecycleScope.launch {
            viewModel.fetchPlans().observe(viewLifecycleOwner) { state ->
                when (state) {
                    is Loading -> {}
                    is Success -> {
                        val plans = state.data as List<ProductResponseDomainModel>
                        for (data in plans) {
                            Timber.d("Pulsa Plans ${data.productCode}")
                        }
                    }

                    is Error -> {Timber.d("Pulsa Plans ${state.exception}")}
                }
            }
        }
    }
}