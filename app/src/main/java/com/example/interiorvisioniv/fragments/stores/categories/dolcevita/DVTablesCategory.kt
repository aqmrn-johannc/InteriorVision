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
import com.example.interiorvisioniv.databinding.FragmentCiTablesBinding
import com.example.interiorvisioniv.databinding.FragmentDvAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentDvTablesBinding

class DVTablesCategory: Fragment(R.layout.fragment_dv_tables) {
    private lateinit var binding : FragmentDvTablesBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDvTablesBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("27", "Table", R.drawable.coffeetable2, "Haven Coffee Table", 124500.00, "0"))
        furnituresArrayList.add(Furnitures("28", "Table", R.drawable.coffeetable3, "Wooden Circular Coffee Table", 9020.00, "0"))
        furnituresArrayList.add(Furnitures("29", "Table", R.drawable.consoletable2, "Design District Console Table", 6600.34, "0"))
        furnituresArrayList.add(Furnitures("30", "Table", R.drawable.consoletable3, "Shanxi Charm Console", 5871.00, "0"))
        furnituresArrayList.add(Furnitures("31", "Table", R.drawable.endtable6, "Brithny End Table", 3506.51, "0"))

    }
}