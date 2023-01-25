package com.mihir.jumpingmindtask.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Amount(
    val unit: String?,
    val value: Double
):Parcelable