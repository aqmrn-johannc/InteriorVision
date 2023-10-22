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
import com.example.interiorvisioniv.databinding.FragmentDvSofasBinding
import com.example.interiorvisioniv.databinding.FragmentMmAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentMmSofasBinding

class MMSofasCategory: Fragment(R.layout.fragment_mm_sofas) {

    private lateinit var binding : FragmentMmSofasBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMmSofasBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("37", "Sofa", R.drawable.sectional3, "Pottery Barn York Sofa", 15000.00, "0"))
        furnituresArrayList.add(Furnitures("38", "Sofa", R.drawable.sectional4, "Chaise Sectional Sofa", 15999.50, "0"))
        furnituresArrayList.add(Furnitures("39", "Sofa", R.drawable.loveseat3, "Mid-Century Cozy Loveseat", 10500.50, "0"))
        furnituresArrayList.add(Furnitures("40", "Sofa", R.drawable.loveseat4, "Fritz Loveseat Sofa", 66866.00, "0"))
        furnituresArrayList.add(Furnitures("41", "Sofa", R.drawable.loveseat5, "Sofa Bed", 20500.00, "0"))


    }
}