package com.example.interiorvisioniv.fragments.stores.categories.romarustico

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
import com.example.interiorvisioniv.databinding.FragmentMmTablesBinding
import com.example.interiorvisioniv.databinding.FragmentRrAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentRrTablesBinding

class RRTablesCategory: Fragment(R.layout.fragment_rr_tables) {
    private lateinit var binding : FragmentRrTablesBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRrTablesBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("58", "Table", R.drawable.coffeetable6, "Retro Coffee Table", 9020.00, "0"))
        furnituresArrayList.add(Furnitures("59", "Table", R.drawable.consoletable5, "Cabinet Console Table", 6600.34, "0"))
        furnituresArrayList.add(Furnitures("60", "Table", R.drawable.consoletable6, "Glass Finesse Console Table", 5871.00, "0"))
        furnituresArrayList.add(Furnitures("61", "Table", R.drawable.endtable7, "Stylish Utility End Table", 3506.51, "0"))

        adapter.onItemClick = {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }
}