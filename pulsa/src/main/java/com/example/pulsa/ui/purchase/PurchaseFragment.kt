package com.example.pulsa.ui.purchase

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.extensions.afterTextChange
import com.example.core.extensions.gone
import com.example.core.extensions.snackbar
import com.example.core.extensions.viewLifecycleScoped
import com.example.core.extensions.visible
import com.example.core.utils.UiState.Error
import com.example.core.utils.UiState.Loading
import com.example.core.utils.UiState.Success
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentPurchaseBinding
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.domain.model.PurchaseRequestDomainModel
import com.example.pulsa.ui.paymentdetails.mapper.PaymentDetailsResolver
import com.example.pulsa.ui.plans.mapper.PlansItemResponseUiToDomainMapper
import com.example.pulsa.ui.plans.model.PlansItemResponseUiModel
import com.example.pulsa.ui.utils.VOUCHER_KEY
import com.example.pulsa.ui.utils.getNavigationResult
import com.example.pulsa.ui.voucher.mapper.VoucherItemResponseUiToDomainMapper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PurchaseFragment : Fragment(R.layout.fragment_purchase) {


    private val binding: FragmentPurchaseBinding by viewLifecycleScoped(
        FragmentPurchaseBinding::bind
    )

    private val viewModel: PurchaseViewModel by viewModels()

    private val args: PurchaseFragmentArgs by navArgs()

    @Inject
    lateinit var plansItemResponseUiToDomainMapper: PlansItemResponseUiToDomainMapper

    @Inject
    lateinit var voucherItemResponseUiToDomainMapper: VoucherItemResponseUiToDomainMapper

    @Inject
    lateinit var paymentDetailsResolver: PaymentDetailsResolver


    private lateinit var selectedPlanArgs: PlansItemResponseUiModel
    private lateinit var selectedPlanDomainModel: PlansItemResponseDomainModel
    private lateinit var purchaseDomainModel: PurchaseRequestDomainModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedPlanArgs = args.selectedPlan
        selectedPlanDomainModel = plansItemResponseUiToDomainMapper.toDomain(selectedPlanArgs)
        getNavigationResult(VOUCHER_KEY)?.observe(viewLifecycleOwner) { it ->
            lifecycleScope.launch {
                val voucher = voucherItemResponseUiToDomainMapper.toDomain(it)
                viewModel.applyVoucher(selectedPlanDomainModel, voucher)
            }
        }
        observeVoucherState()
        renderPurchase()
        setClickListener()
    }


    private fun renderPurchase() {
        binding.apply {
            tvMobileNumber.text = selectedPlanArgs.mobileNumber
            tvPurchaseItemName.text =
                "${selectedPlanArgs.productName} ${selectedPlanArgs.mobileNumber}"
            tvPurchaseItemAmount.text =
                getString(R.string.currency, selectedPlanArgs.rechargeAmount)
            tvSubTotalAmount.text =
                getString(R.string.currency, selectedPlanArgs.rechargeAmount)
            setPayIn30DaysAmount(selectedPlanArgs.rechargeAmount)
        }
    }


    private fun observeVoucherState() {
        viewModel.voucherApplicationState.observe(viewLifecycleOwner) { purchase ->
            purchaseDomainModel = purchase
            if (purchase.voucherApplied) {
                showVoucherApplied(purchase)
            } else {
                showApplyVoucher()
            }
        }
    }

    private fun setClickListener() {
        binding.apply {

            btnViewVoucher.setOnClickListener {
                navigateToVoucherBottomSheet()
            }

            ivVoucherClose.setOnClickListener {
                lifecycleScope.launch {
                    viewModel.removeVoucher(selectedPlanDomainModel)
                }
            }

            etPin.afterTextChange {
                binding.apply {
                    btnPay.isEnabled = it.length >= 6
                }
            }

            btnPay.setOnClickListener {
                makePayment()
            }
        }
    }

    private fun makePayment() {
        lifecycleScope.launch {
            viewModel.makePayment().observe(viewLifecycleOwner) { state ->
                when (state) {
                    is Loading -> {}
                    is Success -> {
                        val paymentDetails =
                            paymentDetailsResolver.resolve(selectedPlanArgs, state.data)
                        findNavController().navigate(
                            PurchaseFragmentDirections.actionPurchaseFragmentPaymentDetailsFragment(
                                paymentDetails
                            )
                        )
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

    private fun navigateToVoucherBottomSheet() {
        val action =
            PurchaseFragmentDirections.actionPurchaseFragmentVoucherBottomSheet(selectedPlanArgs)
        findNavController().navigate(action)
    }

    private fun showVoucherApplied(purchase: PurchaseRequestDomainModel) {
        binding.apply {
            clApplyVoucher.gone()
            clVoucherApplied.visible()
            grKredivoDiscount.visible()
            tvKredivoDiscountAmount.text =
                getString(R.string.currency, purchase.maxDiscount)
            tvVoucherDiscount.text = getString(
                R.string.discount_up_to,
                purchase.maxDiscount
            )
            tvVoucherDiscountMessage.text =
                getString(
                    R.string.voucher_applied_message,
                    purchase.percentage,
                    purchase.maxDiscount
                )
            setPayIn30DaysAmount(purchase.discountAmount)
        }

    }

    private fun showApplyVoucher() {
        binding.apply {
            clApplyVoucher.visible()
            clVoucherApplied.gone()
            grKredivoDiscount.gone()
            setPayIn30DaysAmount(selectedPlanArgs.rechargeAmount)
        }
    }

    private fun setPayIn30DaysAmount(amount: Int) {
        binding.tvPaymentDaysAmount.text = getString(R.string.currency, amount)
    }
}
