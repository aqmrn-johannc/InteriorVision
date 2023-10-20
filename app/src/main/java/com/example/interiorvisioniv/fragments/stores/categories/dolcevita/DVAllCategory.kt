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
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1,
            R.drawable.iv_logo1
        )

        nameId = arrayOf(
            getString(R.string.dolce1),
            getString(R.string.dolce2),
            getString(R.string.dolce3),
            getString(R.string.dolce4),
            getString(R.string.dolce5),
            getString(R.string.dolce6),
            getString(R.string.dolce7),
            getString(R.string.dolce8),
            getString(R.string.dolce9),
            getString(R.string.dolce10),
            getString(R.string.dolce11),
            getString(R.string.dolce12),
            getString(R.string.dolce13),
            getString(R.string.dolce14),
            getString(R.string.dolce15),
            getString(R.string.dolce16)
        )

        for (i in imageId.indices){

            val furnitures = Furnitures(imageId[i],nameId[i])
            furnituresArrayList.add(furnitures)
        }
    }

}