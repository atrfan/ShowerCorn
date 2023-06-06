package com.atrfan.showercorn.ui.adapter

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.atrfan.showercorn.R
import com.atrfan.showercorn.bean.ImageItem
import com.atrfan.showercorn.databinding.ImageItemBinding
import com.bumptech.glide.Glide

class RecommendListAdapter(
    private val parent: Context?,
    private val images: List<ImageItem>
) :
    RecyclerView.Adapter<RecommendListAdapter.ImageListRecyclerViewHolder>() {
    inner class ImageListRecyclerViewHolder(val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListRecyclerViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImageListRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageListRecyclerViewHolder, position: Int) {
        val binding = holder.binding
        val image = images[position]
        Glide.with(binding.root)
            .load(image.imageUrl)
            .fitCenter()
            .into(binding.image)
        binding.imageTitle.text = image.imageTitle
        binding.uploadUser.text = image.artistName

        binding.root.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pid", image.pid.toString())
            val parent = binding.root.parent as RecyclerView
            parent.findNavController().navigate(R.id.action_recommend_to_detail, bundle, null, null)
        }


//        binding.root.setOnClickListener {
//            val intent = Intent(parent, ImageDetailActivity::class.java)
//            intent.putExtra("pid", image.pid)
//            parent.startActivity(intent)
//        }
    }
}