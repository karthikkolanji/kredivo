package com.example.pulsa.ui.voucher

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.core.extensions.gone
import com.example.core.extensions.shortToast
import com.example.core.extensions.snackbar
import com.example.core.extensions.viewLifecycleScoped
import com.example.core.extensions.visible
import com.example.core.utils.UiState
import com.example.pulsa.R
import com.example.pulsa.databinding.BottomSheetVoucherBinding
import com.example.pulsa.ui.plans.model.PlansItemResponseUiModel
import com.example.pulsa.ui.purchase.PurchaseFragmentArgs
import com.example.pulsa.ui.purchase.mapper.PlansItemResponseUiToDomainMapper
import com.example.pulsa.ui.voucher.mapper.VoucherItemResponseDomainToUiMapper
import com.example.pulsa.ui.voucher.mapper.VoucherResponseDomainToUiMapper
import com.example.pulsa.ui.voucher.model.VoucherItemResponseUiModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class VoucherBottomSheetDialog(private val onVoucherAppliedAction: (VoucherItemResponseUiModel) -> Unit) :
    BottomSheetDialogFragment(R.layout.bottom_sheet_voucher) {

    constructor() : this({})

    private val binding: BottomSheetVoucherBinding by viewLifecycleScoped(
        BottomSheetVoucherBinding::bind
    )

    private val viewModel: VoucherViewModel by viewModels()

    private val args: PurchaseFragmentArgs by navArgs()

    @Inject
    lateinit var voucherResponseDomainToUiMapper: VoucherResponseDomainToUiMapper

    @Inject
    lateinit var  plansItemResponseUiToDomainMapper: PlansItemResponseUiToDomainMapper

    lateinit var selectedPlan: PlansItemResponseUiModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedPlan = args.plan
        observerVoucher()
    }

    private fun observerVoucher() {
        lifecycleScope.launch {
            viewModel.getVoucher(plansItemResponseUiToDomainMapper.toDomain(selectedPlan)).observe(viewLifecycleOwner) { state ->
                when (state) {
                    is UiState.Loading -> {
                        binding.apply {
                            progressview.visible()
                            rvVoucher.gone()
                            tvEmptyVoucher.gone()
                        }
                    }

                    is UiState.Success -> {
                        val voucher = voucherResponseDomainToUiMapper.toUi(state.data)
                        setAdapter(VoucherAdapter(voucher.voucherItems) { voucher ->

                        })
                    }

                    is UiState.Error -> {
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


    private fun setAdapter(adapter: VoucherAdapter) {
        binding.rvVoucher.adapter = adapter
        if (adapter.itemCount == 0) {
            binding.apply {
                progressview.gone()
                rvVoucher.gone()
                tvEmptyVoucher.visible()
            }
        } else {
            binding.apply {
                progressview.gone()
                tvEmptyVoucher.gone()
                rvVoucher.visible()
            }
        }
    }

}