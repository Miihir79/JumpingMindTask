package com.mihir.jumpingmindtask.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Method(
    val fermentation: Fermentation,
    val mash_temp: List<MashTemp>,
    val twist: String?
):Parcelable