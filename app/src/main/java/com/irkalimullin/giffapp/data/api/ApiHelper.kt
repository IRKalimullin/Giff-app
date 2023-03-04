package com.irkalimullin.giffapp.data.api

const val API_KEY = "ANgUp2sH2BgC9YbVFjH85oMo1JVsgPBa"

/**
 * Вспомогательный класс для вызова RetrofitService
 */
class ApiHelper(private val retrofitService: RetrofitService) {

    suspend fun getTrendingGifList() = retrofitService.getTrendingGifList(API_KEY)

    suspend fun getSearchedGifList(searchText: String) =
        retrofitService.getSearchedGifList(API_KEY, searchText)

}