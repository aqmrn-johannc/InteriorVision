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
    private lateinit var furnituresArrayList : ArrayList<Furnitures>

    lateinit var imageId : Array<Int>
    lateinit var nameId : Array<String>

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
            R.drawable.decorlamp5,
            R.drawable.decorlamp6,
            R.drawable.plant5,
            R.drawable.plant6,
            R.drawable.vase6,
            R.drawable.loveseat6,
            R.drawable.loveseat7,
            R.drawable.sectional5,
            R.drawable.sectional6,
            R.drawable.sofa6,
            R.drawable.sofa7,
            R.drawable.coffeetable6,
            R.drawable.consoletable5,
            R.drawable.consoletable6,
            R.drawable.endtable7
        )

        nameId = arrayOf(
            "Minimalist Lava",
            "Silhouette Lamp",
            "Money Plant",
            "Banana Plant",
            "Porcelain China Vase",
            "Lawson",
            "Mid-Century Modern Sofa",
            "West Elm Haven",
            "Pottery Barn Carmel Sofa",
            "Mid-Century Sofa",
            "Industrial Sofa",
            "Retro '70s Coffee Table",
            "Cabinet Console Table",
            "Sleek Glass Finesse Console Table",
            "Stylish Utility End Table"
        )

        for (i in imageId.indices){

            val furnitures = Furnitures(imageId[i],nameId[i])
            furnituresArrayList.add(furnitures)
        }
    }

}