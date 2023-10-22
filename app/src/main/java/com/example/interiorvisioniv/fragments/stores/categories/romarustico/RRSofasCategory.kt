package com.example.interiorvisioniv.fragments.stores.categories.romarustico

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.activities.ProductDetailsActivity
import com.example.interiorvisioniv.adapters.FurnitureAdapter
import com.example.interiorvisioniv.data.Furnitures
import com.example.interiorvisioniv.databinding.FragmentMmSofasBinding
import com.example.interiorvisioniv.databinding.FragmentRrAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentRrSofasBinding

class RRSofasCategory: Fragment(R.layout.fragment_rr_sofas) {

    private lateinit var binding : FragmentRrSofasBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

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
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FurnitureAdapter(furnituresArrayList, requireContext())
        recyclerView.adapter = adapter

        furnituresArrayList.add(Furnitures("52", "Sofa", R.drawable.loveseat6, "Lawson", 15000.00, "0"))
        furnituresArrayList.add(Furnitures("53", "Sofa", R.drawable.loveseat7, "Mid-Century Modern Sofa", 15999.50, "0"))
        furnituresArrayList.add(Furnitures("54", "Sofa", R.drawable.sectional5, "West Elm Haven", 10500.50, "0"))
        furnituresArrayList.add(Furnitures("55", "Sofa", R.drawable.sectional6, "Pottery Barn Carmel Sofa", 66866.00, "0"))
        furnituresArrayList.add(Furnitures("56", "Sofa", R.drawable.sofa6, "Mid-Century Sofa", 20500.00, "0"))
        furnituresArrayList.add(Furnitures("57", "Sofa", R.drawable.sofa7, "Industrial Sofa", 124500.00, "0"))

        adapter.onItemClick = {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }
}