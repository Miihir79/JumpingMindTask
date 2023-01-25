package com.mihir.jumpingmindtask.network

import android.app.Application
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mihir.jumpingmindtask.BASE_URL
import com.mihir.jumpingmindtask.PER_PAGE_ITEMS
import com.mihir.jumpingmindtask.model.BeerDataItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import androidx.paging.Pager
import androidx.preference.PreferenceManager
import com.mihir.jumpingmindtask.ui.adapters.BeerPagingSource
import retrofit2.converter.gson.GsonConverterFactory

class AppObjectController {

    companion object {
        private val gson: Gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        val service: NetworkService by lazy { retrofit.create(NetworkService::class.java) }

        fun getBeerData(): Flow<PagingData<BeerDataItem>> {
            val pagingSource =
                BeerPagingSource(service)
            return Pager(
                config = PagingConfig(
                    pageSize = PER_PAGE_ITEMS,
                    enablePlaceholders = false
                ),
                pagingSourceFactory = { pagingSource }
            ).flow
        }

    }

}