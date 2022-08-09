package com.example.topshiriq.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.topshiriq.api.Constants
import com.example.topshiriq.model.PostModel
import com.example.topshiriq.databinding.PostItemLayoutBinding

class PostAdapter(val items: List<PostModel>) : RecyclerView.Adapter<PostAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: PostItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            PostItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items.get(position)

        holder.binding.tvName.text = item.name
        holder.binding.tvPrice.text = item.price
        Glide.with(holder.itemView.context).load(Constants.IMAGE + item.image)
            .into(holder.binding.imgImage)

    }

    override fun getItemCount(): Int {
        return items.count()
    }
}