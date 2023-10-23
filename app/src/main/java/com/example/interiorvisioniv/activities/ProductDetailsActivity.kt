package com.example.interiorvisioniv.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.data.Furnitures
import com.example.interiorvisioniv.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val furniture = intent.getParcelableExtra<Furnitures>("product")
        if (furniture != null) {
            val productName: TextView = binding.productName
            val productImage: ImageView = binding.productImage

            productName.text = furniture.furnitureName
            productImage.setImageResource(furniture.furnitureImage)
        }

        binding.btCamera.setOnClickListener {
            val intent = Intent(this, AugmentedRealityActivity::class.java)
            startActivity(intent)
        }
    }
}