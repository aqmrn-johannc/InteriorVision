package com.example.interiorvisioniv.fragments.stores.categories.casaitaliana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.adapters.FurnitureAdapter
import com.example.interiorvisioniv.data.Furnitures
import com.example.interiorvisioniv.databinding.FragmentCiAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentCiChairsBinding
import com.example.interiorvisioniv.databinding.FragmentCiDecorsBinding

class CIDecorsCategory: Fragment(R.layout.fragment_ci_decors) {

    private lateinit var binding : FragmentCiDecorsBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCiDecorsBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("5", "Decor", R.drawable.vase1, "Rawscan Vase", 1000.34, "0"))
        furnituresArrayList.add(Furnitures("6", "Decor", R.drawable.vase2, "Hydria Apothecary Vase", 5000.00, "0"))
        furnituresArrayList.add(Furnitures("7", "Decor", R.drawable.plants1, "Potted Montsera Deliciosa", 1099.50, "0"))
        furnituresArrayList.add(Furnitures("8", "Decor", R.drawable.plants2, "Prayer Plant", 999.50, "0"))

    }

}