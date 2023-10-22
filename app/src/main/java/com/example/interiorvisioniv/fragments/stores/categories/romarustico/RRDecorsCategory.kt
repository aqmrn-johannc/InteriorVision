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
import com.example.interiorvisioniv.databinding.FragmentMmDecorsBinding
import com.example.interiorvisioniv.databinding.FragmentRrAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentRrDecorsBinding

class RRDecorsCategory: Fragment(R.layout.fragment_rr_decors) {

    private lateinit var binding : FragmentRrDecorsBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRrDecorsBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("47", "Decor", R.drawable.decorlamp5, "Minimalist Lava Lamp", 10900.00, "0"))
        furnituresArrayList.add(Furnitures("48", "Decor", R.drawable.decorlamp6, "Silhouette Lamp", 20875.00, "0"))
        furnituresArrayList.add(Furnitures("49", "Decor", R.drawable.plant5, "Money Plant", 9800.00, "0"))
        furnituresArrayList.add(Furnitures("50", "Decor", R.drawable.plant6, "Banana Plant", 14404.34, "0"))
        furnituresArrayList.add(Furnitures("51", "Decor", R.drawable.vase6, "Porcelain China Vase", 1000.34, "0"))

        adapter.onItemClick = {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }
}