package com.mihir.jumpingmindtask.ui

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.showToast(message:String){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun Fragment.showToast(message: String) = requireView().showToast(message)