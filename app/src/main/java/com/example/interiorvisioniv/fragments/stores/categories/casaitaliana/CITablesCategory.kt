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
import com.example.interiorvisioniv.databinding.FragmentCiSofasBinding
import com.example.interiorvisioniv.databinding.FragmentCiTablesBinding

class CITablesCategory: Fragment(R.layout.fragment_ci_tables) {
    private lateinit var binding : FragmentCiTablesBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCiTablesBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("13", "Table", R.drawable.endtable1, "Sakcham End Table", 6600.34, "0"))
        furnituresArrayList.add(Furnitures("14", "Table", R.drawable.endtable2, "Retro Box End Table", 5871.00, "0"))
        furnituresArrayList.add(Furnitures("15", "Table", R.drawable.consoletable1, "Simple Console Table", 3506.51, "0"))
        furnituresArrayList.add(Furnitures("16", "Table", R.drawable.coffeetable1, "Victorian Coffee Table", 2889.60, "0"))
    }

}