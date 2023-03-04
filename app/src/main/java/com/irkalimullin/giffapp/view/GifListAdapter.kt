package com.irkalimullin.giffapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.irkalimullin.giffapp.GlideApp
import com.irkalimullin.giffapp.R
import com.irkalimullin.giffapp.data.model.Gif

/**
 * Адаптер для RecyclerView с отображением списка гифок
 */
class GifListAdapter(
    private val context: Context,
    private val openDetail: (gif: Gif) -> Unit
) : ListAdapter<Gif, GifListAdapter.GifViewHolder>(GifListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.gif_item, null)
        return GifViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val url = getItem(position).images!!.original!!.url
        holder.bind(url!!)
        holder.imageView.setOnClickListener {
            openDetail(getItem(position))
        }
    }

    class GifViewHolder(val context: Context, view: View) : ViewHolder(view) {

        var imageView: ImageView

        init {
            imageView = view.findViewById(R.id.gif_image_view)
        }

        fun bind(url: String) {
            GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.ic_baseline_downloading_24)
                .into(imageView)
        }
    }

    class GifListDiffCallback : DiffUtil.ItemCallback<Gif>() {
        override fun areItemsTheSame(oldItem: Gif, newItem: Gif): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Gif, newItem: Gif): Boolean {
            return oldItem.id == newItem.id
        }

    }
}