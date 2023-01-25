package com.mihir.jumpingmindtask.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Malt(
    val amount: Amount,
    val name: String?
):Parcelable