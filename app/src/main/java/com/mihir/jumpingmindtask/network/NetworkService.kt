package com.mihir.jumpingmindtask.network

import com.mihir.jumpingmindtask.model.BeerData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("beers")
    suspend fun getBeerData(@Query("page") page: Int):Response<BeerData>
}