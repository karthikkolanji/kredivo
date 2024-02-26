package com.example.pulsa.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TopUpPagerAdapter(
    fragment: Fragment,
    private val fragments: List<Fragment>,
    private val titles: List<String>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]

    fun getPageTitle(position: Int) = titles[position]
}