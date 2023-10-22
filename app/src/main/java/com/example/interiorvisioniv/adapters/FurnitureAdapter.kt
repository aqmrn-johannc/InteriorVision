package com.example.interiorvisioniv.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.engine.DiskCacheStrategy
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.data.Furnitures
import com.google.android.material.imageview.ShapeableImageView

class FurnitureAdapter(private val furnitureList : ArrayList<Furnitures>) : RecyclerView.Adapter<FurnitureAdapter.MyViewHolder>() {
    init {
        Log.d("FurnitureAdapter", "Adapter initialized with ${furnitureList.size} items") // Log message
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.casa_all, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = furnitureList[position]
        holder.furnitureName.text = currentItem.furnitureName

//        try {
//            Glide.with(holder.itemView.context)
//                .load(currentItem.furnitureImage)
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .centerCrop()
//                .into(holder.furnitureImage)
//        } catch (e: Exception) {
//            Log.e("ImageLoadingError", "Error loading image: ${e.message}")
//        }
    }

    override fun getItemCount(): Int {
        return furnitureList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val furnitureImage : ShapeableImageView = itemView.findViewById(R.id.furniture_image)
        val furnitureName : TextView = itemView.findViewById(R.id.furniture_name)
    }

}