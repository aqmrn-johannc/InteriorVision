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
import com.example.interiorvisioniv.databinding.FragmentDvDecorsBinding
import com.example.interiorvisioniv.databinding.FragmentMmDecorsBinding

class MMDecorsCategory: Fragment(R.layout.fragment_mm_decors) {

    private lateinit var binding : FragmentMmDecorsBinding

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
        binding = FragmentMmDecorsBinding.inflate(inflater)
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
        )

        nameId = arrayOf(
            getString(R.string.model5),
            getString(R.string.model6),
            getString(R.string.model7),
            getString(R.string.model8)
        )

        for (i in imageId.indices){

            val furnitures = Furnitures(imageId[i],nameId[i])
            furnituresArrayList.add(furnitures)
        }
    }

}