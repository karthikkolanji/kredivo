package com.example.core.extensions

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.text.HtmlCompat
import com.google.android.material.snackbar.Snackbar

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.snackbar(message: String, duration: Int): Snackbar =
    Snackbar.make(
        this,
        HtmlCompat.fromHtml(
            "<font color=\"#ffffff\">${message}</font>",
            HtmlCompat.FROM_HTML_MODE_LEGACY,
        ),
        duration,)


fun View.setBooleanVisibility(value: Boolean) {
    if (value) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.isVisible() = visibility == View.VISIBLE

fun TextView.setHtmlText(@StringRes stringId: Int) {
    this.text = HtmlCompat.fromHtml(context.getString(stringId), HtmlCompat.FROM_HTML_MODE_LEGACY)
}
