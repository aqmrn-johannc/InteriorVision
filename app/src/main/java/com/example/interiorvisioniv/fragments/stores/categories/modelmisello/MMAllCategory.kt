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
    private lateinit var furnituresArrayList : ArrayList<Furnitures>

    lateinit var imageId : Array<Int>
    lateinit var nameId : Array<String>

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
            R.drawable.vase4,
            R.drawable.vase5,
            R.drawable.plant4,
            R.drawable.decorlamp3,
            R.drawable.decorlamp4,
            R.drawable.sectional3,
            R.drawable.sectional4,
            R.drawable.loveseat3,
            R.drawable.loveseat4,
            R.drawable.loveseat5,
            R.drawable.coffeetable5,
            R.drawable.consoletable4,
            R.drawable.endtable3,
            R.drawable.endtable4,
            R.drawable.endtable5
        )

        nameId = arrayOf(
            "Ancient Vase",
            "Gilded Elegance Vase",
            "Zen Skimmia",
            "Opulent Marble Lamp",
            "Botanical Lamp",
            "Pottery Barn York Sofa",
            "Chaise Sectional Sofa",
            "18th Century Cozy Loveseat",
            "Fritz Loveseat Sofa",
            "Sofa Bed",
            "Organizer's Brew Table",
            "Batchelor's Legacy Console Table",
            "Retasha End Table",
            "Cage Wire End Table",
            "Pebble End Table",
        )

        for (i in imageId.indices){

            val furnitures = Furnitures(imageId[i],nameId[i])
            furnituresArrayList.add(furnitures)
        }
    }

}