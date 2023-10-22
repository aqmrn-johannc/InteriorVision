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
import com.example.interiorvisioniv.databinding.FragmentDvAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentMmAllcategoryBinding

class MMAllCategory: Fragment(R.layout.fragment_mm_allcategory) {

    private lateinit var binding : FragmentMmAllcategoryBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMmAllcategoryBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("32", "Decor", R.drawable.vase4, "Ancient Vase", 10900.00, "0"))
        furnituresArrayList.add(Furnitures("33", "Decor", R.drawable.vase5, "Gilded Elegance Vase", 20875.00, "0"))
        furnituresArrayList.add(Furnitures("34", "Decor", R.drawable.plant4, "Zen Skimmia", 9800.00, "0"))
        furnituresArrayList.add(Furnitures("35", "Decor", R.drawable.decorlamp3, "Opulent Marble Lamp", 14404.34, "0"))
        furnituresArrayList.add(Furnitures("36", "Decor", R.drawable.decorlamp4, "Botanical Lamp", 1000.34, "0"))
        furnituresArrayList.add(Furnitures("37", "Sofa", R.drawable.sectional3, "Pottery Barn York Sofa", 15000.00, "0"))
        furnituresArrayList.add(Furnitures("38", "Sofa", R.drawable.sectional4, "Chaise Sectional Sofa", 15999.50, "0"))
        furnituresArrayList.add(Furnitures("39", "Sofa", R.drawable.loveseat3, "Mid-Century Cozy Loveseat", 10500.50, "0"))
        furnituresArrayList.add(Furnitures("40", "Sofa", R.drawable.loveseat4, "Fritz Loveseat Sofa", 66866.00, "0"))
        furnituresArrayList.add(Furnitures("41", "Sofa", R.drawable.loveseat5, "Sofa Bed", 20500.00, "0"))
        furnituresArrayList.add(Furnitures("42", "Table", R.drawable.coffeetable5, "Organizer's Brew Table", 124500.00, "0"))
        furnituresArrayList.add(Furnitures("43", "Table", R.drawable.consoletable4, "Bachelor's Console Table", 9020.00, "0"))
        furnituresArrayList.add(Furnitures("44", "Table", R.drawable.endtable3, "Retasha End Table", 6600.34, "0"))
        furnituresArrayList.add(Furnitures("45", "Table", R.drawable.endtable4, "Cage Wire End Table", 5871.00, "0"))
        furnituresArrayList.add(Furnitures("46", "Table", R.drawable.endtable5, "Pebble End Table", 3506.51, "0"))

    }
}