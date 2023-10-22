package com.example.interiorvisioniv.fragments.stores.categories.casaitaliana

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.activities.ProductDetailsActivity
import com.example.interiorvisioniv.adapters.FurnitureAdapter
import com.example.interiorvisioniv.data.Furnitures
import com.example.interiorvisioniv.databinding.FragmentCiAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentCiChairsBinding

class CIChairsCategory: Fragment(R.layout.fragment_ci_chairs) {

    private lateinit var binding : FragmentCiChairsBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCiChairsBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FurnitureAdapter(furnituresArrayList, requireContext())
        recyclerView.adapter = adapter

        furnituresArrayList.add(Furnitures("1", "Chair", R.drawable.chair1, "Berge Chair", 17800.00, "0"))
        furnituresArrayList.add(Furnitures("2", "Chair", R.drawable.chair2, "Barrel Chair", 20875.00, "0"))
        furnituresArrayList.add(Furnitures("3", "Chair", R.drawable.chair3, "Mid-Century Chair", 14057.30, "0"))
        furnituresArrayList.add(Furnitures("4", "Chair", R.drawable.chair4, "Slipper Chair", 14404.34, "0"))

        adapter.onItemClick = {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }

}