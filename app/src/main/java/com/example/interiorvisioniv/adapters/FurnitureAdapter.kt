package com.example.interiorvisioniv.adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.data.Furnitures
import com.example.interiorvisioniv.helper.COL_FAV_STATUS
import com.example.interiorvisioniv.helper.DBHelper
import com.google.android.material.imageview.ShapeableImageView
import de.hdodenhof.circleimageview.CircleImageView

class FurnitureAdapter(private val furnitureList : ArrayList<Furnitures>, private val context: Context) : RecyclerView.Adapter<FurnitureAdapter.MyViewHolder>() {

    private lateinit var db: DBHelper
    var onItemClick: ((Furnitures) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        db = DBHelper(context)

        var sp: SharedPreferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        var firstStart = sp.getBoolean("firstStart", true)
        if (firstStart) {
            createTableOnFirstStart()
        }
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.casa_all, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val furnitureItem = furnitureList[position]

        readCursorData(furnitureItem, holder)

        Glide.with(context)
            .load(furnitureItem.furnitureImage)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(holder.furnitureImage)

        holder.furnitureName.text = furnitureItem.furnitureName
        val price = furnitureItem.furniturePrice
        holder.furniturePrice.text = price.toString()

        holder.btFavorite.setOnClickListener {
            if (furnitureItem.favStatus == "0") {
                furnitureItem.favStatus = "1"
                db.insertFurnitureData(furnitureItem.itemId, furnitureItem.category,
                    furnitureItem.furnitureImage, furnitureItem.furnitureName, furnitureItem.furniturePrice, furnitureItem.favStatus)
                holder.btFavorite.setBackgroundResource(R.drawable.favorite_filled)
            } else {
                furnitureItem.favStatus = "0"
                db.removeFromFaves(furnitureItem.itemId)
                holder.btFavorite.setBackgroundResource(R.drawable.favorite_border)
            }
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(furnitureItem)
        }
    }


    override fun getItemCount(): Int {
        return furnitureList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val furnitureImage : ShapeableImageView = itemView.findViewById(R.id.furniture_image)
        val furnitureName : TextView = itemView.findViewById(R.id.furniture_name)
        val furniturePrice : TextView = itemView.findViewById(R.id.furniture_price)
        val btFavorite : Button = itemView.findViewById(R.id.btFavorite)
    }

    private fun createTableOnFirstStart() {
        var sp = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        var editor = sp.edit()
        editor.putBoolean("firstStart", false)
        editor.apply()
    }

    private fun readCursorData(furnitureItem: Furnitures, holder: MyViewHolder) {
        var cursor = db.readAllFurnitureData(furnitureItem.itemId)
        var myDB = db.readableDatabase
        try {
            while (cursor.moveToNext()){
                var itemFavStatus = cursor.getString(cursor.getColumnIndexOrThrow(COL_FAV_STATUS))
                furnitureItem.favStatus = itemFavStatus

                if (itemFavStatus != null && itemFavStatus == "1") {
                    holder.btFavorite.setBackgroundResource(R.drawable.favorite_filled)
                }
                else if (itemFavStatus != null && itemFavStatus == "0") {
                    holder.btFavorite.setBackgroundResource(R.drawable.favorite_border)
                }
            }
        } finally {
            if (cursor != null && cursor.isClosed) {
                cursor.close()
                myDB.close()
            }
        }
    }

}
