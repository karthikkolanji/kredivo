package com.example.core.extensions

import com.example.core.BuildConfig
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

inline fun debug(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block()
    }
}

fun String.convertDateFormat(): String {
    val inputFormatter = DateTimeFormatter.ISO_DATE_TIME
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH)
    val date = LocalDateTime.parse(this, inputFormatter)
    return date.format(outputFormatter)

}