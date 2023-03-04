package com.irkalimullin.giffapp.data.api

import com.irkalimullin.giffapp.data.model.Data
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("trending?limit=25&rating=g")
    suspend fun getTrendingGifList(@Query("api_key") apiKey: String): Data

    @GET("search?&limit=25&offset=0&rating=g&lang=en")
    suspend fun getSearchedGifList(
        @Query("api_key") apiKey: String,
        @Query("q") searchText: String
    ): Data

}