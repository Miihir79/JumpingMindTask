package com.mihir.jumpingmindtask.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "fav_beer")
data class BeerDataItem(
    val abv: Double,
    val attenuation_level: Double,
    val boil_volume: BoilVolume,
    val brewers_tips: String?,
    val contributed_by: String?,
    val description: String?,
    val ebc: Int,
    val first_brewed: String?,
    val food_pairing: List<String>,
    val ibu: Double,
    @PrimaryKey
    val id: Int,
    val image_url: String?,
    val ingredients: Ingredients,
    val method: Method,
    val name: String?,
    val ph: Double,
    val srm: Double,
    val tagline: String?,
    val target_fg: Int,
    val target_og: Double,
    val volume: Volume
): Parcelable