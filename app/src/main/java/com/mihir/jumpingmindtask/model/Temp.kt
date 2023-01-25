package com.mihir.jumpingmindtask.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Temp(
    val unit: String?,
    val value: Int
):Parcelable