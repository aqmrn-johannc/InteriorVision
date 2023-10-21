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
import com.example.interiorvisioniv.databinding.FragmentMmSofasBinding
import com.example.interiorvisioniv.databinding.FragmentRrSofasBinding

class RRSofasCategory: Fragment(R.layout.fragment_rr_sofas) {

    private lateinit var binding : FragmentRrSofasBinding

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
        binding = FragmentRrSofasBinding.inflate(inflater)
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
            R.drawable.loveseat6,
            R.drawable.loveseat7,
            R.drawable.sectional5,
            R.drawable.sectional6,
            R.drawable.sofa6,
            R.drawable.sofa7
        )

        nameId = arrayOf(
            "Lawson",
            "Mid-Century Modern Sofa",
            "West Elm Haven",
            "Pottery Barn Carmel Sofa",
            "Mid-Century Sofa",
            "Industrial Sofa"
        )

        for (i in imageId.indices){

            val furnitures = Furnitures(imageId[i],nameId[i])
            furnituresArrayList.add(furnitures)
        }
    }
}