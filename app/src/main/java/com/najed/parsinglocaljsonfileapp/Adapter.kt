package com.najed.parsinglocaljsonfileapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.najed.parsinglocaljsonfileapp.databinding.ImageItemBinding

class Adapter(private val context: Context, private val imagesList: Image): RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ImageItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image = imagesList[position]
        holder.binding.apply {
            Glide.with(context).load(image.url).into(imageIv)
            imageTitle.text = image.title
        }
    }

    override fun getItemCount() = imagesList.size
}