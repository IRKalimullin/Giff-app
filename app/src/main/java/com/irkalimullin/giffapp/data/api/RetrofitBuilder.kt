package com.irkalimullin.giffapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://api.giphy.com/v1/gifs/"

    val retrofitService: RetrofitService = getData().create(RetrofitService::class.java)

    private fun getData(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}