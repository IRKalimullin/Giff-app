package com.irkalimullin.giffapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.irkalimullin.giffapp.GlideApp
import com.irkalimullin.giffapp.R
import com.irkalimullin.giffapp.databinding.ActivityGifDetailBinding

const val EXTRA_GIF_URL = "EXTRA_GIF_URL"
const val EXTRA_GIF_TITLE = "EXTRA_GIF_TITLE"
const val EXTRA_GIF_USERNAME = "EXTRA_GIF_USERNAME"

/**
 * Второй экран, отображающий гифку, название и имя пользователя, добавившего гифку.
 * Активность получает параметры через Intent и только отображает полученные данные.
 */
class GifDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGifDetailBinding
    private lateinit var gifUrl: String

    //Переменные привязаны к TextView с помощью dataBinding
    var gifTitle: String = ""
    var gifUsername: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gif_detail)
        binding.activity = this
        setContentView(binding.root)

        gifUrl = intent.getStringExtra(EXTRA_GIF_URL).toString()
        gifTitle = intent.getStringExtra(EXTRA_GIF_TITLE).toString()
        gifUsername = intent.getStringExtra(EXTRA_GIF_USERNAME).toString()

        GlideApp.with(this)
            .load(gifUrl)
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .into(binding.gifDetailImageView)
    }

    //Метод для закрытия Activity вызывается через привязку dataBinding
    fun closeDetailActivity() {
        finish()
    }
}