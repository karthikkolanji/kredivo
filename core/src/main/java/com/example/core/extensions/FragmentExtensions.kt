package com.example.core.extensions

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.core.extensions.longToast
import com.example.core.extensions.shortToast

fun Fragment.shortToast(message: String?) = requireContext().shortToast(message)

fun Fragment.shortToast(@StringRes resId: Int) = requireContext().shortToast(resId)

fun Fragment.longToast(message: String?) = requireContext().longToast(message)

fun Fragment.longToast(@StringRes resId: Int) = requireContext().longToast(resId)
