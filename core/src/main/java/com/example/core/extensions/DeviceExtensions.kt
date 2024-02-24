package com.example.core.extensions

import android.os.Build
import com.example.core.BuildConfig

inline fun debug(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block()
    }
}