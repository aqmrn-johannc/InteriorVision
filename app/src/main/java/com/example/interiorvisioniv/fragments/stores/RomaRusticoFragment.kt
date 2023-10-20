package com.example.interiorvisioniv.fragments.stores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interiorvisioniv.adapters.HomeViewPagerAdapter
import com.example.interiorvisioniv.databinding.FragmentRomaRusticoBinding
import com.example.interiorvisioniv.fragments.stores.categories.romarustico.RRAllCategory
import com.example.interiorvisioniv.fragments.stores.categories.romarustico.RRChairsCategory
import com.example.interiorvisioniv.fragments.stores.categories.romarustico.RRDecorsCategory
import com.example.interiorvisioniv.fragments.stores.categories.romarustico.RRSofasCategory
import com.example.interiorvisioniv.fragments.stores.categories.romarustico.RRTablesCategory
import com.google.android.material.tabs.TabLayoutMediator

class RomaRusticoFragment : Fragment() {

    private lateinit var binding: FragmentRomaRusticoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRomaRusticoBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            RRAllCategory(),
            RRChairsCategory(),
            RRDecorsCategory(),
            RRSofasCategory(),
            RRTablesCategory()
        )

        val viewPager2Adapter =
            HomeViewPagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab,position ->
            when(position){
                0 -> tab.text = "All"
                1 -> tab.text = "Chairs"
                2 -> tab.text = "Decors"
                3 -> tab.text = "Sofas"
                4 -> tab.text = "Tables"
            }
        }.attach()
    }

}