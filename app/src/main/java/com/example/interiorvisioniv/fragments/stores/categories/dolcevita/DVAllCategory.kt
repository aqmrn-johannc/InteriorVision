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
    private lateinit var furnituresArrayList : ArrayList<Furnitures>

    lateinit var imageId : Array<Int>
    lateinit var nameId : Array<String>

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
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FurnitureAdapter(furnituresArrayList)
        recyclerView.adapter = adapter

    }
    private fun dataInitialize(){

        furnituresArrayList = arrayListOf<Furnitures>()

        imageId = arrayOf(
            R.drawable.chair5,
            R.drawable.decorlamp1,
            R.drawable.decorlamp2,
            R.drawable.plant3,
            R.drawable.vase3,
            R.drawable.sofa5,
            R.drawable.sectional1,
            R.drawable.sectional2,
            R.drawable.loveseat1,
            R.drawable.loveseat2,
            R.drawable.coffeetable2,
            R.drawable.coffeetable3,
            R.drawable.consoletable2,
            R.drawable.consoletable3,
            R.drawable.endtable6
        )

        nameId = arrayOf(
            "Occasional Chair",
            "LuxuryWood Illuminare",
            "Charcoal Jungle Lamp",
            "High Polymer Jade Plant",
            "Cranes in Flight Duo Vases",
            "Retro Sofa",
            "Zin Home Sofa",
            "JoyBird Sofa",
            "English Roll Arm Loveseat Sofa",
            "English Roll Arm Sofa",
            "Haven Coffee Table",
            "Wooden Circular Coffee Table",
            "Design District Console Table",
            "Shanxi Charm Console",
            "Brithny End Table"
        )

        for (i in imageId.indices){

            val furnitures = Furnitures(imageId[i],nameId[i])
            furnituresArrayList.add(furnitures)
        }
    }

}