package com.example.pulsa.ui.purchase

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.core.extensions.viewLifecycleScoped
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentPurchaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurchaseFragment : Fragment(R.layout.fragment_purchase) {

    private val binding: FragmentPurchaseBinding by viewLifecycleScoped(
        FragmentPurchaseBinding::bind
    )

    private val args: PurchaseFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderPurchase()
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
}
