package com.irkalimullin.giffapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irkalimullin.giffapp.data.api.ApiHelper
import com.irkalimullin.giffapp.data.repository.GifRepository

class GifViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GifViewModel::class.java)) {
            return GifViewModel(GifRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}