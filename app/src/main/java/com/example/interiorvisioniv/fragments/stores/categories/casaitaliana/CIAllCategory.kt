package com.example.interiorvisioniv.fragments.stores.categories.casaitaliana

import android.os.Bundle
import android.util.Log
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

class CIAllCategory: Fragment(R.layout.fragment_ci_allcategory) {

    private lateinit var binding : FragmentCiAllcategoryBinding

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
        binding = FragmentCiAllcategoryBinding.inflate(inflater)
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
        Log.d("TAG", "Inside dataInitialize()")
        furnituresArrayList = arrayListOf<Furnitures>()

        imageId = arrayOf(
            R.drawable.chair1,
            R.drawable.chair2,
            R.drawable.chair3,
            R.drawable.chair4,
            R.drawable.vase1,
            R.drawable.vase2,
            R.drawable.plants1,
            R.drawable.plants2,
            R.drawable.sofa1,
            R.drawable.sofa2,
            R.drawable.sofa3,
            R.drawable.sofa4,
            R.drawable.endtable1,
            R.drawable.endtable2,
            R.drawable.consoletable1,
            R.drawable.coffeetable1
        )

        nameId = arrayOf(
            "Berge Chair",
            "Barrel Chair",
            "Mid-Century Chair",
            "Slipper Chair",
            "Rawscan Vase",
            "Hydria Apotechary Vase",
            "Potted Montsera Deliciosa",
            "Prayer Plant",
            "Tuxedo Sofa",
            "Track Arm Lawson",
            "Chesterfield Sofa",
            "Lawson",
            "Sakcham End Table",
            "Retro Box End Table",
            "Simple Console Table",
            "Victorian Coffee Table"
        )

        for (i in imageId.indices){

            val furnitures = Furnitures(imageId[i],nameId[i])
            furnituresArrayList.add(furnitures)
        }
    }

}