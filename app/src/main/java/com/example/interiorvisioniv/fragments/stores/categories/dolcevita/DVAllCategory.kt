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
import com.example.interiorvisioniv.databinding.FragmentCiAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentDvAllcategoryBinding

class DVAllCategory: Fragment(R.layout.fragment_dv_allcategory) {

    private lateinit var binding : FragmentDvAllcategoryBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDvAllcategoryBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("17", "Chair", R.drawable.chair5, "Occasional Chair", 10900.00, "0"))
        furnituresArrayList.add(Furnitures("18", "Decor", R.drawable.decorlamp1, "LuxuryWood Illuminare", 20875.00, "0"))
        furnituresArrayList.add(Furnitures("19", "Decor", R.drawable.decorlamp2, "Charcoal Jungle Lamp", 14057.30, "0"))
        furnituresArrayList.add(Furnitures("20", "Decor", R.drawable.plant3, "Jade Plant", 14404.34, "0"))
        furnituresArrayList.add(Furnitures("21", "Decor", R.drawable.vase3, "Cranes in Flight Duo Vases", 1000.34, "0"))
        furnituresArrayList.add(Furnitures("22", "Sofa", R.drawable.sofa5, "Retro Sofa", 5000.00, "0"))
        furnituresArrayList.add(Furnitures("23", "Sofa", R.drawable.sectional1, "Zin Home Sofa", 15999.50, "0"))
        furnituresArrayList.add(Furnitures("24", "Sofa", R.drawable.sectional2, "Joybird Sofa", 10500.50, "0"))
        furnituresArrayList.add(Furnitures("25", "Sofa", R.drawable.loveseat1, "English Loveseat Sofa", 66866.00, "0"))
        furnituresArrayList.add(Furnitures("26", "Sofa", R.drawable.loveseat2, "Roll Arm Sofa", 20500.00, "0"))
        furnituresArrayList.add(Furnitures("27", "Table", R.drawable.coffeetable2, "Haven Coffee Table", 124500.00, "0"))
        furnituresArrayList.add(Furnitures("28", "Table", R.drawable.coffeetable3, "Wooden Circular Coffee Table", 9020.00, "0"))
        furnituresArrayList.add(Furnitures("29", "Table", R.drawable.consoletable2, "Design District Console Table", 6600.34, "0"))
        furnituresArrayList.add(Furnitures("30", "Table", R.drawable.consoletable3, "Shanxi Charm Console", 5871.00, "0"))
        furnituresArrayList.add(Furnitures("31", "Table", R.drawable.endtable6, "Brithny End Table", 3506.51, "0"))

    }
}