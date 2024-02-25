package com.example.pulsa.ui.plans

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.extensions.gone
import com.example.core.extensions.snackbar
import com.example.core.extensions.viewLifecycleScoped
import com.example.core.extensions.visible
import com.example.core.utils.UiState.Error
import com.example.core.utils.UiState.Loading
import com.example.core.utils.UiState.Success
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentPulsaPlansBinding
import com.example.pulsa.ui.TopUpFragmentDirections
import com.example.pulsa.ui.plans.mapper.PlansResponseDomainToUiMapper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PulsaPlansFragment : Fragment(R.layout.fragment_pulsa_plans) {

    private val binding: FragmentPulsaPlansBinding by viewLifecycleScoped(
        FragmentPulsaPlansBinding::bind
    )
    private val viewModel: PulsaPlansViewModel by viewModels()

    @Inject
    lateinit var plansResponseDomainToUiMapper: PlansResponseDomainToUiMapper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerPlans()
    }

    private fun observerPlans() {
        lifecycleScope.launch {
            viewModel.fetchPlans().observe(viewLifecycleOwner) { state ->
                when (state) {
                    is Loading -> {
                        binding.apply {
                            progressview.visible()
                            rvPulsaPlans.gone()
                            tvEmptyPlans.gone()
                        }
                    }

                    is Success -> {
                        val plans = plansResponseDomainToUiMapper.toUi(state.data)
                        setAdapter(PlansAdapter(plans.item) { plan ->
                            findNavController().navigate(
                                TopUpFragmentDirections.actionTopupFragmentToPurchaseFragment(plan)
                            )
                        })
                    }

                    is Error -> {
                        state.exception.localizedMessage?.let {
                            binding.rootView.snackbar(
                                it,
                                Toast.LENGTH_LONG
                            )
                        }
                    }
                }
            }
        }
    }

    private fun setAdapter(adapter: PlansAdapter) {
        binding.rvPulsaPlans.adapter = adapter
        if (adapter.itemCount == 0) {
            binding.apply {
                progressview.gone()
                rvPulsaPlans.gone()
                tvEmptyPlans.visible()
            }
        } else {
            binding.apply {
                progressview.gone()
                tvEmptyPlans.gone()
                rvPulsaPlans.visible()
            }
        }
    }
}
