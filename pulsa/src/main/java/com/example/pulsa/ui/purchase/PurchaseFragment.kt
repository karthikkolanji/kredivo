package com.example.pulsa.ui.purchase

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.core.extensions.gone
import com.example.core.extensions.viewLifecycleScoped
import com.example.core.extensions.visible
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentPurchaseBinding
import com.example.pulsa.ui.purchase.mapper.VoucherToPurchaseResolver
import com.example.pulsa.ui.purchase.model.PurchaseRequestUiModel
import com.example.pulsa.ui.voucher.VoucherBottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PurchaseFragment : Fragment(R.layout.fragment_purchase) {

    private val binding: FragmentPurchaseBinding by viewLifecycleScoped(
        FragmentPurchaseBinding::bind
    )

    private val viewModel: PurchaseViewModel by viewModels()

    private val args: PurchaseFragmentArgs by navArgs()

    @Inject
    lateinit var voucherToPurchaseResolver: VoucherToPurchaseResolver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderPurchase()
        observeVoucherState()
        setClickListener()
    }


    private fun renderPurchase() {
        val plan = args.plan
        binding.apply {
            tvMobileNumber.text = plan.mobileNumber
            tvPurchaseItemName.text = "${plan.productName} ${plan.mobileNumber}"
            tvPurchaseItemAmount.text = plan.rechargeAmount.toString()
            tvPurchaseItemAmount.text = plan.rechargeAmount.toString()
        }
    }

    private fun observeVoucherState() {
        viewModel.appliedVoucher.observe(viewLifecycleOwner) { purchase ->
            binding.apply {
                if (purchase.voucherApplied.not()) {
                    clApplyVoucher.visible()
                    clVoucherApplied.gone()
                } else {
                    clApplyVoucher.gone()
                    clVoucherApplied.visible()
                }
            }
        }
    }

    private fun setClickListener() {
        binding.apply {

            btnViewVoucher.setOnClickListener {
                VoucherBottomSheetDialog { voucher ->
                    viewModel.applyVoucher(voucherToPurchaseResolver.resolve(voucher))
                }.show(childFragmentManager, "ModelBottomSheer")
            }

            ivVoucherClose.setOnClickListener {
                viewModel.removeVoucher(PurchaseRequestUiModel())
            }
        }
    }
}
