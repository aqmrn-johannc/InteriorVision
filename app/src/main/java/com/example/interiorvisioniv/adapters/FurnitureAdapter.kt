package com.example.interiorvisioniv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.data.Furnitures
import com.google.android.material.imageview.ShapeableImageView

class FurnitureAdapter(private val furnitureList : ArrayList<Furnitures>) : RecyclerView.Adapter<FurnitureAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.casa_all, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = furnitureList[position]
        holder.furnitureImage.setImageResource(currentItem.furnitureImage)
        holder.furnitureName.text = currentItem.furnitureName
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