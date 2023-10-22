package com.example.interiorvisioniv.fragments.stores.categories.dolcevita

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
import com.example.interiorvisioniv.databinding.FragmentCiDecorsBinding
import com.example.interiorvisioniv.databinding.FragmentDvAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentDvDecorsBinding

class DVDecorsCategory: Fragment(R.layout.fragment_dv_decors) {

    private lateinit var binding : FragmentDvDecorsBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDvDecorsBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("18", "Decor", R.drawable.decorlamp1, "LuxuryWood Illuminare", 20875.00, "0"))
        furnituresArrayList.add(Furnitures("19", "Decor", R.drawable.decorlamp2, "Charcoal Jungle Lamp", 14057.30, "0"))
        furnituresArrayList.add(Furnitures("20", "Decor", R.drawable.plant3, "Jade Plant", 14404.34, "0"))
        furnituresArrayList.add(Furnitures("21", "Decor", R.drawable.vase3, "Cranes in Flight Duo Vases", 1000.34, "0"))


    }
}