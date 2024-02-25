package com.example.pulsa.ui.datapackage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.core.extensions.viewLifecycleScoped
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentDataPackageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataPackageFragment : Fragment(R.layout.fragment_data_package) {

    private val binding: FragmentDataPackageBinding by viewLifecycleScoped(
        FragmentDataPackageBinding::bind
    )
    private val viewModel: DataPackageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
