package com.mihir.jumpingmindtask.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hop(
    val add: String?,
    val amount: Amount,
    val attribute: String?,
    val name: String?
):Parcelable