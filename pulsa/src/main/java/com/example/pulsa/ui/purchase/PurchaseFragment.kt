package com.example.pulsa.ui.purchase

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.extensions.viewLifecycleScoped
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentPurchaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurchaseFragment : Fragment(R.layout.fragment_purchase) {

    private val binding: FragmentPurchaseBinding by viewLifecycleScoped(
        FragmentPurchaseBinding::bind
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
