package com.example.interiorvisioniv.fragments.stores.categories.casaitaliana

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
import com.example.interiorvisioniv.databinding.FragmentCiAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentCiDecorsBinding
import com.example.interiorvisioniv.databinding.FragmentCiSofasBinding

class CISofasCategory: Fragment(R.layout.fragment_ci_sofas) {

    private lateinit var binding : FragmentCiSofasBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCiSofasBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("9", "Sofa", R.drawable.sofa1, "Tuxedo Sofa", 66866.00, "0"))
        furnituresArrayList.add(Furnitures("10", "Sofa", R.drawable.sofa2, "Track Arm Lawson", 34307.00, "0"))
        furnituresArrayList.add(Furnitures("11", "Sofa", R.drawable.sofa3, "Chesterfield Sofa", 124500.00, "0"))
        furnituresArrayList.add(Furnitures("12", "Sofa", R.drawable.sofa4, "Lawson", 39020.00, "0"))

        adapter.onItemClick = {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }
}