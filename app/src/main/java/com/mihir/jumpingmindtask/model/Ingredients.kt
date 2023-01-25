package com.mihir.jumpingmindtask.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingredients(
    val hops: List<Hop>,
    val malt: List<Malt>,
    val yeast: String?
):Parcelable