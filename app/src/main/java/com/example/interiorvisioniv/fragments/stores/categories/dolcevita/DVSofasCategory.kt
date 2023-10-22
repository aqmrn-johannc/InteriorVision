package com.example.interiorvisioniv.fragments.stores.categories.dolcevita

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
import com.example.interiorvisioniv.databinding.FragmentCiSofasBinding
import com.example.interiorvisioniv.databinding.FragmentDvAllcategoryBinding
import com.example.interiorvisioniv.databinding.FragmentDvSofasBinding

class DVSofasCategory: Fragment(R.layout.fragment_dv_sofas) {

    private lateinit var binding : FragmentDvSofasBinding

    private lateinit var  adapter : FurnitureAdapter
    private lateinit var  recyclerView: RecyclerView
    private var furnituresArrayList = ArrayList<Furnitures>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDvSofasBinding.inflate(inflater)
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

        furnituresArrayList.add(Furnitures("22", "Sofa", R.drawable.sofa5, "Retro Sofa", 5000.00, "0"))
        furnituresArrayList.add(Furnitures("23", "Sofa", R.drawable.sectional1, "Zin Home Sofa", 15999.50, "0"))
        furnituresArrayList.add(Furnitures("24", "Sofa", R.drawable.sectional2, "Joybird Sofa", 10500.50, "0"))
        furnituresArrayList.add(Furnitures("25", "Sofa", R.drawable.loveseat1, "English Loveseat Sofa", 66866.00, "0"))
        furnituresArrayList.add(Furnitures("26", "Sofa", R.drawable.loveseat2, "Roll Arm Sofa", 20500.00, "0"))

        adapter.onItemClick = {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }

    }
}