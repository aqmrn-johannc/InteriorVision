package com.example.interiorvisioniv.fragments.stores.categories.casaitaliana

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

class CIAllCategory: Fragment(R.layout.fragment_ci_allcategory) {

    private lateinit var binding : FragmentCiAllcategoryBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCiAllcategoryBinding.inflate(inflater)
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
        furnituresArrayList.add(Furnitures("5", "Decor", R.drawable.vase1, "Rawscan Vase", 1000.34, "0"))
        furnituresArrayList.add(Furnitures("6", "Decor", R.drawable.vase2, "Hydria Apothecary Vase", 5000.00, "0"))
        furnituresArrayList.add(Furnitures("7", "Decor", R.drawable.plants1, "Potted Montsera Deliciosa", 1099.50, "0"))
        furnituresArrayList.add(Furnitures("8", "Decor", R.drawable.plants2, "Prayer Plant", 999.50, "0"))
        furnituresArrayList.add(Furnitures("9", "Sofa", R.drawable.sofa1, "Tuxedo Sofa", 66866.00, "0"))
        furnituresArrayList.add(Furnitures("10", "Sofa", R.drawable.sofa2, "Track Arm Lawson", 34307.00, "0"))
        furnituresArrayList.add(Furnitures("11", "Sofa", R.drawable.sofa3, "Chesterfield Sofa", 124500.00, "0"))
        furnituresArrayList.add(Furnitures("12", "Sofa", R.drawable.sofa4, "Lawson", 39020.00, "0"))
        furnituresArrayList.add(Furnitures("13", "Table", R.drawable.endtable1, "Sakcham End Table", 6600.34, "0"))
        furnituresArrayList.add(Furnitures("14", "Table", R.drawable.endtable2, "Retro Box End Table", 5871.00, "0"))
        furnituresArrayList.add(Furnitures("15", "Table", R.drawable.consoletable1, "Simple Console Table", 3506.51, "0"))
        furnituresArrayList.add(Furnitures("16", "Table", R.drawable.coffeetable1, "Victorian Coffee Table", 2889.60, "0"))

        adapter.onItemClick = {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }

}