package com.mpg.assignment1.extentions

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun Context.showToast(message:String, duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, duration).show()
}
