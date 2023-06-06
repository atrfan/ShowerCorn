package com.atrfan.showercorn.util

import android.content.Context
import android.widget.Toast

/**
 * @author atrfan
 * @date 2023-03-17 20:26
 */
object ShowToast {

    fun String.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, this, duration).show()
    }

    fun Int.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, this, duration).show()
    }
}