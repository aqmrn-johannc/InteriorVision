package com.example.interiorvisioniv.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.ActivityShopBinding
import com.google.android.material.internal.ContextUtils.getActivity

class ShopActivity : AppCompatActivity() {

    val binding by lazy{
        ActivityShopBinding.inflate(layoutInflater)
    }

    private lateinit var sp: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = findNavController(R.id.shopHostFragment)
        binding.bottomNavigation.setupWithNavController(navController)

        sp = getSharedPreferences("Data", Context.MODE_PRIVATE)
        editor = sp.edit()
    }
}