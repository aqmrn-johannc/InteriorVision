package com.example.interiorvisioniv.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.ActivityShopBinding

class ShopActivity : AppCompatActivity() {

    val binding by lazy{
        ActivityShopBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = findNavController(R.id.shopHostFragment)
        binding.bottomNavigation.setupWithNavController(navController)
    }
}