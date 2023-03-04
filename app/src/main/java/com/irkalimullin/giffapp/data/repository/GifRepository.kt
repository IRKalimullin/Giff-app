package com.irkalimullin.giffapp.data.repository

import com.irkalimullin.giffapp.data.api.ApiHelper

class GifRepository(private val apiHelper: ApiHelper) {
    suspend fun getTrendingGifList() = apiHelper.getTrendingGifList()
    suspend fun getSearchedGifList(searchText: String) = apiHelper.getSearchedGifList(searchText)
}