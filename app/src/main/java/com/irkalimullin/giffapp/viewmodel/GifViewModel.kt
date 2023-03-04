package com.irkalimullin.giffapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.irkalimullin.giffapp.data.repository.GifRepository
import kotlinx.coroutines.Dispatchers

/**
 * ViewModel для получения данных по запросу через retrofit,
 * содержит два метода для получения списка трендовых гифок и списка гифок по поиску.
 */
class GifViewModel(private val repository: GifRepository) : ViewModel() {

    fun getTrendingGifList() = liveData(Dispatchers.IO) {
        try {
            emit(repository.getTrendingGifList())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getSearchedGifList(searchText: String) = liveData(Dispatchers.IO) {
        try {
            emit(repository.getSearchedGifList(searchText))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}