package com.irkalimullin.giffapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.irkalimullin.giffapp.R
import com.irkalimullin.giffapp.data.api.ApiHelper
import com.irkalimullin.giffapp.data.api.RetrofitBuilder
import com.irkalimullin.giffapp.data.model.Gif
import com.irkalimullin.giffapp.databinding.ActivityMainBinding
import com.irkalimullin.giffapp.viewmodel.GifViewModel
import com.irkalimullin.giffapp.viewmodel.GifViewModelFactory

/**
 * Главный экран содержащий список 25 популярных гифок и строку поиска.
 * Активность получает данные из ViewModel, загружает их в recyclerView.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = GifListAdapter(this) { openGifDetail(it) }
    private lateinit var gifViewModel: GifViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        setContentView(binding.root)

        gifViewModel =
            ViewModelProvider(
                this,
                GifViewModelFactory(ApiHelper(RetrofitBuilder.retrofitService))
            )[GifViewModel::class.java]

        val layoutManager = GridLayoutManager(this, 2)
        binding.gifListRecyclerView.layoutManager = layoutManager
        binding.gifListRecyclerView.adapter = adapter

        getTrendingGifs()
    }

    private fun getSearchedGifs(text: String) {
        gifViewModel.getTrendingGifList().removeObservers(this)

        gifViewModel.getSearchedGifList(text).observe(this) {
            it?.let {
                adapter.submitList(it.data)
            }
        }
    }

    //Метод для поиска гифок, вызывается через привязку dataBinding
    fun searchGifs() {
        val text = binding.searchInputText.text.toString()
        if (text.isNotEmpty()) {
            binding.trendingTitle.visibility = View.GONE
            binding.searchedTitle.visibility = View.VISIBLE
            getSearchedGifs(text)
        }
    }

    private fun getTrendingGifs() {
        gifViewModel.getTrendingGifList().observe(this) {
            it?.let {
                adapter.submitList(it.data)
            }
        }
    }

    private fun openGifDetail(gif: Gif) {
        val intent = Intent(this, GifDetailActivity::class.java).apply {
            putExtra(EXTRA_GIF_URL, gif.images!!.original!!.url)
            putExtra(EXTRA_GIF_TITLE, gif.title)
            putExtra(EXTRA_GIF_USERNAME, gif.username)
        }
        startActivity(intent)
    }
}