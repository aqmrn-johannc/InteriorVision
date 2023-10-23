package com.example.interiorvisioniv.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.data.FavItem
import com.example.interiorvisioniv.helper.DBHelper
import com.google.android.material.imageview.ShapeableImageView
import de.hdodenhof.circleimageview.CircleImageView

class FavoritesAdapter(private val favoriteList: ArrayList<FavItem>, private val context: Context) : RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {

    private lateinit var db: DBHelper

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.casa_all, parent, false)
        db = DBHelper(context)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.furnitureName.text = favoriteList[position].itemName
        holder.furnitureImage.setImageResource(favoriteList[position].itemImage)
        holder.furniturePrice.text = favoriteList[position].itemPrice.toString()
        holder.btFavorite.setBackgroundResource(R.drawable.favorite_filled)

        holder.btFavorite.setOnClickListener {
            val favItem = favoriteList[position]
            db.removeFromFaves(favItem.itemId)
            removeItem(position)
        }
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val furnitureImage : ShapeableImageView = itemView.findViewById(R.id.furniture_image)
        val furnitureName : TextView = itemView.findViewById(R.id.furniture_name)
        val furniturePrice : TextView = itemView.findViewById(R.id.furniture_price)
        val btFavorite : Button = itemView.findViewById(R.id.btFavorite)
    }

    private fun removeItem(position: Int) {
        if (position >= 0 && position < favoriteList.size) {
            favoriteList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, favoriteList.size)
        }
    }
}