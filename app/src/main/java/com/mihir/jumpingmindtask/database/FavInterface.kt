package com.mihir.jumpingmindtask.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mihir.jumpingmindtask.model.BeerDataItem

@Dao
interface FavInterface {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFav(beer:BeerDataItem)

    @Query("SELECT * FROM fav_beer")
    fun getFavs():LiveData<List<BeerDataItem>>

    @Delete
    suspend fun deleteFav(beer: BeerDataItem)
}