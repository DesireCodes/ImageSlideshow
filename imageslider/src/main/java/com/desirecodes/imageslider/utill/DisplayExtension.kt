package com.desirecodes.imageslider.utill

import android.content.res.Resources

fun Int.dpToPx(): Float {
    val density = Resources.getSystem()
        .displayMetrics.density
    return this * density
}
fun Int.dpToPxInt(): Int {
    val density = Resources.getSystem()
        .displayMetrics.density
    return this * density.toInt()
}
