package com.example.pulsa.ui.paymentdetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.core.extensions.viewLifecycleScoped
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentPaymentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentDetailsFragment : Fragment(R.layout.fragment_payment_details) {

    private val binding: FragmentPaymentDetailsBinding by viewLifecycleScoped(
        FragmentPaymentDetailsBinding::bind
    )

    private val args: PaymentDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderPaymentDetails()
    }

    private fun renderPaymentDetails() {
        val paymentDetails = args.paymentDetails
        binding.apply {
            tvMobileNumber.text = paymentDetails.mobileNumber
            tvStatus.text = paymentDetails.status
            tvOrderId.text = paymentDetails.orderId
            tvProductName.text = paymentDetails.productName
            tvProductAmount.text = getString(R.string.currency, paymentDetails.rechargeAmount)
            tvSubTotalAmount.text = getString(R.string.currency, paymentDetails.subtotalAmount)
            tvPaymentDaysAmount.text =
                getString(R.string.currency, paymentDetails.payIn30DaysAmount)
        }
    }
}
