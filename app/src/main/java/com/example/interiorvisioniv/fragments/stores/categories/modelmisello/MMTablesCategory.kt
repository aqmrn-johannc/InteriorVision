package com.example.interiorvisioniv.fragments.stores.categories.modelmisello

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
import com.example.interiorvisioniv.databinding.FragmentDvTablesBinding
import com.example.interiorvisioniv.databinding.FragmentMmAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentMmTablesBinding

class MMTablesCategory: Fragment(R.layout.fragment_mm_tables) {
    private lateinit var binding : FragmentMmTablesBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMmTablesBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("42", "Table", R.drawable.coffeetable5, "Organizer's Brew Table", 124500.00, "0"))
        furnituresArrayList.add(Furnitures("43", "Table", R.drawable.consoletable4, "Bachelor's Console Table", 9020.00, "0"))
        furnituresArrayList.add(Furnitures("44", "Table", R.drawable.endtable3, "Retasha End Table", 6600.34, "0"))
        furnituresArrayList.add(Furnitures("45", "Table", R.drawable.endtable4, "Cage Wire End Table", 5871.00, "0"))
        furnituresArrayList.add(Furnitures("46", "Table", R.drawable.endtable5, "Pebble End Table", 3506.51, "0"))

    }
}