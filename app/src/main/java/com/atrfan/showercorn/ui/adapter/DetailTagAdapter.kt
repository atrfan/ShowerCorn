package com.atrfan.showercorn.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atrfan.showercorn.databinding.DetailImageTagsBinding

class DetailTagAdapter( val tags: MutableList<String>) :
    RecyclerView.Adapter<DetailTagAdapter.DetailTagViewHolder>() {
    inner class DetailTagViewHolder(val binding: DetailImageTagsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailTagViewHolder {
        val binding =
            DetailImageTagsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailTagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailTagViewHolder, position: Int) {
        val binding = holder.binding
        binding.tagName.text = tags[position]
    }

    override fun getItemCount(): Int = tags.size
}