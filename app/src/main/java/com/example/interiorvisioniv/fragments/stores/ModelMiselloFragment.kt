package com.example.interiorvisioniv.fragments.stores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.adapters.HomeViewPagerAdapter
import com.example.interiorvisioniv.databinding.FragmentModelMiselloBinding
import com.example.interiorvisioniv.fragments.stores.categories.modelmisello.MMAllCategory
import com.example.interiorvisioniv.fragments.stores.categories.modelmisello.MMChairsCategory
import com.example.interiorvisioniv.fragments.stores.categories.modelmisello.MMDecorsCategory
import com.example.interiorvisioniv.fragments.stores.categories.modelmisello.MMSofasCategory
import com.example.interiorvisioniv.fragments.stores.categories.modelmisello.MMTablesCategory
import com.google.android.material.tabs.TabLayoutMediator

class ModelMiselloFragment : Fragment() {

    private lateinit var binding: FragmentModelMiselloBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentModelMiselloBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MMAllCategory(),
//            MMChairsCategory(),
            MMDecorsCategory(),
            MMSofasCategory(),
            MMTablesCategory()
        )

        val viewPager2Adapter =
            HomeViewPagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab,position ->
            when(position){
                0 -> tab.text = "All"
//                1 -> tab.text = "Chairs"
                1 -> tab.text = "Decors"
                2 -> tab.text = "Sofas"
                3 -> tab.text = "Tables"
            }
        }.attach()

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_modelMiselloFragment_to_homeFragment)
        }
    }

}