package com.example.pulsa.ui.purchase

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.extensions.viewLifecycleScoped
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentPurchaseBinding
import com.example.pulsa.ui.plans.model.PlansItemResponseUiModel
import com.example.pulsa.ui.purchase.mapper.VoucherToPurchaseResolver
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

    lateinit var plan: PlansItemResponseUiModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plan = args.plan
        renderPurchase()
        observeVoucherState()
        setClickListener()
    }


    private fun renderPurchase() {
        binding.apply {
            tvMobileNumber.text = plan.mobileNumber
            tvPurchaseItemName.text = "${plan.productName} ${plan.mobileNumber}"
            tvPurchaseItemAmount.text = getString(R.string.currency, plan.rechargeAmount.toString())
            tvSubTotalAmount.text = getString(R.string.currency, plan.rechargeAmount.toString())
        }
    }

    private fun observeVoucherState() {
//        binding.apply {
//            if (voucher == null) {
//                clApplyVoucher.visible()
//                clVoucherApplied.gone()
//                grKredivoDiscount.gone()
//            } else {
//                clApplyVoucher.gone()
//                clVoucherApplied.visible()
//                grKredivoDiscount.visible()
//                tvKredivoDiscountAmount.text =
//                    getString(R.string.currency, voucher.maxDiscount)
//                tvVoucherDiscount.text = getString(
//                    R.string.max_discount,
//                    voucher.discountPercentage.toString(),
//                    voucher.maxDiscount
//                )
//                tvVoucherDiscountMessage.text =
//                    getString(R.string.valid_until, voucher.voucherValidity)
//            }
//        }

    }

    private fun setClickListener() {
        binding.apply {
            btnViewVoucher.setOnClickListener {
                findNavController().navigate(
                    PurchaseFragmentDirections.actionPurchaseFragmentVoucherBottomSheet(
                        plan
                    )
                )
            }

            ivVoucherClose.setOnClickListener {
            }
        }
    }
}
