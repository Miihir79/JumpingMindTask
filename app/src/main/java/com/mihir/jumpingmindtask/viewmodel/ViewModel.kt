package com.mihir.jumpingmindtask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mihir.jumpingmindtask.network.AppObjectController
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class ViewModel(application: Application): AndroidViewModel(application) {

    val beerData = flow {
        emitAll(AppObjectController.getBeerData().cachedIn(viewModelScope))
    }

}