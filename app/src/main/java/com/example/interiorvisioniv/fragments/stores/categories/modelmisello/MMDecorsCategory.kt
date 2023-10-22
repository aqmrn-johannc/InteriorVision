package com.example.interiorvisioniv.fragments.stores.categories.modelmisello

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
import com.example.interiorvisioniv.databinding.FragmentDvDecorsBinding
import com.example.interiorvisioniv.databinding.FragmentMmAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentMmDecorsBinding

class MMDecorsCategory: Fragment(R.layout.fragment_mm_decors) {

    private lateinit var binding : FragmentMmDecorsBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

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
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FurnitureAdapter(furnituresArrayList, requireContext())
        recyclerView.adapter = adapter

        furnituresArrayList.add(Furnitures("32", "Decor", R.drawable.vase4, "Ancient Vase", 10900.00, "0"))
        furnituresArrayList.add(Furnitures("33", "Decor", R.drawable.vase5, "Gilded Elegance Vase", 20875.00, "0"))
        furnituresArrayList.add(Furnitures("34", "Decor", R.drawable.plant4, "Zen Skimmia", 9800.00, "0"))
        furnituresArrayList.add(Furnitures("35", "Decor", R.drawable.decorlamp3, "Opulent Marble Lamp", 14404.34, "0"))
        furnituresArrayList.add(Furnitures("36", "Decor", R.drawable.decorlamp4, "Botanical Lamp", 1000.34, "0"))


        adapter.onItemClick = {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }
}