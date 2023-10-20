package com.example.interiorvisioniv.fragments.stores.categories.casaitaliana

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
            getString(R.string.casa1),
            getString(R.string.casa2),
            getString(R.string.casa3),
            getString(R.string.casa4),
            getString(R.string.casa5),
            getString(R.string.casa6),
            getString(R.string.casa7),
            getString(R.string.casa8),
            getString(R.string.casa9),
            getString(R.string.casa10),
            getString(R.string.casa11),
            getString(R.string.casa12),
            getString(R.string.casa13),
            getString(R.string.casa14),
            getString(R.string.casa15),
            getString(R.string.casa16)
        )

        for (i in imageId.indices){

            val furnitures = Furnitures(imageId[i],nameId[i])
            furnituresArrayList.add(furnitures)
        }
    }

}