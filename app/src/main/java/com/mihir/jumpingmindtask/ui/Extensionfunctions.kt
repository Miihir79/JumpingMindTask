package com.mihir.jumpingmindtask.ui

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

private lateinit var toast: Toast

// This file stores all the extension functions to make code concise

fun View.showToast(message:String){
    if (::toast.isInitialized) {
        toast.cancel()
    }
    toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
    toast.show()
}

/**
 * Function used to show toast message: [message] Toast.LENGTH_LONG
 */
fun Fragment.showToast(message: String) = requireView().showToast(message)