package com.example.topshiriq.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.topshiriq.R
import com.example.topshiriq.model.CategoryModel
import com.example.topshiriq.databinding.CategoryItemLayoutBinding

interface CategoryAdapterCallback {
    fun onClinkItem(item: CategoryModel)
}

class CategoryAdapter(val items: List<CategoryModel>, val callback: CategoryAdapterCallback) :
    RecyclerView.Adapter<CategoryAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: CategoryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            CategoryItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            items.forEach {
                it.checked = false
            }

            item.checked = true

            callback.onClinkItem(item)

            notifyDataSetChanged()
        }

        holder.binding.TvTitle.text = item.title

        if (item.checked){
            holder.binding.CardView.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.yellow))
            holder.binding.TvTitle.setTextColor(Color.WHITE)
        }else{
            holder.binding.CardView.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.grey))
            holder.binding.TvTitle.setTextColor(Color.BLACK)
        }
    }

    override fun getItemCount(): Int = items.count()
}
