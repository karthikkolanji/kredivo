package com.example.pulsa.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.extensions.viewLifecycleScoped
import com.example.pulsa.R
import com.example.pulsa.databinding.FragmentTopUpBinding
import com.example.pulsa.ui.datapackage.DataPackageFragment
import com.example.pulsa.ui.plans.PulsaPlansFragment
import com.google.android.material.tabs.TabLayoutMediator

class TopUpFragment : Fragment(R.layout.fragment_top_up)  {
    private val binding: FragmentTopUpBinding by viewLifecycleScoped(
        FragmentTopUpBinding::bind
    )
    private lateinit var pagerAdapter: MyPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val fragmentList = mutableListOf<Fragment>()
        fragmentList.add(PulsaPlansFragment())
        fragmentList.add(DataPackageFragment())

        val titleList = listOf(getString(R.string.pulsa), getString(R.string.data_package))
        pagerAdapter = MyPagerAdapter(requireActivity(), fragmentList, titleList)
        binding.viewPager.adapter = pagerAdapter

        binding.apply {
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = titleList[position]
            }.attach()
        }

    }
}