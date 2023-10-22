package com.example.interiorvisioniv.fragments.stores.categories.romarustico

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
import com.example.interiorvisioniv.databinding.FragmentMmAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentRrAllcategoryBinding

class RRAllCategory: Fragment(R.layout.fragment_rr_allcategory) {

    private lateinit var binding : FragmentRrAllcategoryBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRrAllcategoryBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("47", "Decor", R.drawable.decorlamp5, "Minimalist Lava Lamp", 10900.00, "0"))
        furnituresArrayList.add(Furnitures("48", "Decor", R.drawable.decorlamp6, "Silhouette Lamp", 20875.00, "0"))
        furnituresArrayList.add(Furnitures("49", "Decor", R.drawable.plant5, "Money Plant", 9800.00, "0"))
        furnituresArrayList.add(Furnitures("50", "Decor", R.drawable.plant6, "Banana Plant", 14404.34, "0"))
        furnituresArrayList.add(Furnitures("51", "Decor", R.drawable.vase6, "Porcelain China Vase", 1000.34, "0"))
        furnituresArrayList.add(Furnitures("52", "Sofa", R.drawable.loveseat6, "Lawson", 15000.00, "0"))
        furnituresArrayList.add(Furnitures("53", "Sofa", R.drawable.loveseat7, "Mid-Century Modern Sofa", 15999.50, "0"))
        furnituresArrayList.add(Furnitures("54", "Sofa", R.drawable.sectional5, "West Elm Haven", 10500.50, "0"))
        furnituresArrayList.add(Furnitures("55", "Sofa", R.drawable.sectional6, "Pottery Barn Carmel Sofa", 66866.00, "0"))
        furnituresArrayList.add(Furnitures("56", "Sofa", R.drawable.sofa6, "Mid-Century Sofa", 20500.00, "0"))
        furnituresArrayList.add(Furnitures("57", "Sofa", R.drawable.sofa7, "Industrial Sofa", 124500.00, "0"))
        furnituresArrayList.add(Furnitures("58", "Table", R.drawable.coffeetable6, "Retro Coffee Table", 9020.00, "0"))
        furnituresArrayList.add(Furnitures("59", "Table", R.drawable.consoletable5, "Cabinet Console Table", 6600.34, "0"))
        furnituresArrayList.add(Furnitures("60", "Table", R.drawable.consoletable6, "Glass Finesse Console Table", 5871.00, "0"))
        furnituresArrayList.add(Furnitures("61", "Table", R.drawable.endtable7, "Stylish Utility End Table", 3506.51, "0"))

    }
}