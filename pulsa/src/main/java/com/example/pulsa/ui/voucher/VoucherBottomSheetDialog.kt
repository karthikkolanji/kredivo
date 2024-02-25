package com.example.pulsa.ui.voucher

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.core.extensions.gone
import com.example.core.extensions.snackbar
import com.example.core.extensions.viewLifecycleScoped
import com.example.core.extensions.visible
import com.example.core.utils.UiState
import com.example.pulsa.R
import com.example.pulsa.databinding.BottomSheetVoucherBinding
import com.example.pulsa.ui.voucher.mapper.VoucherResponseDomainToUiMapper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class VoucherBottomSheetDialog : BottomSheetDialogFragment(R.layout.bottom_sheet_voucher) {

    private val binding: BottomSheetVoucherBinding by viewLifecycleScoped(
        BottomSheetVoucherBinding::bind
    )

    private val viewModel: VoucherViewModel by viewModels()

    @Inject
    lateinit var voucherResponseDomainToUiMapper: VoucherResponseDomainToUiMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerPlans()
    }

    private fun observerPlans() {
        lifecycleScope.launch {
            viewModel.getVoucher().observe(viewLifecycleOwner) { state ->
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