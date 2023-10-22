package com.example.interiorvisioniv.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.data.Furnitures

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val furniture = intent.getParcelableExtra<Furnitures>("product")
        if (furniture != null) {
            val productName: TextView = findViewById(R.id.productName)
            val productImage: ImageView = findViewById(R.id.productImage)

            productName.text = furniture.furnitureName
            productImage.setImageResource(furniture.furnitureImage)
        }
    }
}