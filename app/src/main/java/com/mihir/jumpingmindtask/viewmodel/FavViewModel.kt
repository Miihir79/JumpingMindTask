package com.mihir.jumpingmindtask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mihir.jumpingmindtask.database.FavDatabase
import com.mihir.jumpingmindtask.model.BeerDataItem
import kotlinx.coroutines.launch

class FavViewModel(application: Application): AndroidViewModel(application) {

    var dao = FavDatabase.getDatabase(application).favDao()
    val readAllFavBeers: LiveData<List<BeerDataItem>> = dao.getFavs()

    fun addFav(searchClass: BeerDataItem){
        viewModelScope.launch {
            dao.addFav(searchClass)
        }
    }

    fun deleteFav(searchClass: BeerDataItem){
        viewModelScope.launch {
            dao.deleteFav(searchClass)
        }
    }

}