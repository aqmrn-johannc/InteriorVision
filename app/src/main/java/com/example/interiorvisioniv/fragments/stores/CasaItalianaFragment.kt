package com.example.interiorvisioniv.fragments.stores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.adapters.HomeViewPagerAdapter
import com.example.interiorvisioniv.databinding.FragmentCasaItalianaBinding
import com.example.interiorvisioniv.fragments.stores.categories.casaitaliana.CIAllCategory
import com.example.interiorvisioniv.fragments.stores.categories.casaitaliana.CIChairsCategory
import com.example.interiorvisioniv.fragments.stores.categories.casaitaliana.CIDecorsCategory
import com.example.interiorvisioniv.fragments.stores.categories.casaitaliana.CISofasCategory
import com.example.interiorvisioniv.fragments.stores.categories.casaitaliana.CITablesCategory
import com.google.android.material.tabs.TabLayoutMediator

class CasaItalianaFragment : Fragment() {

    private lateinit var binding: FragmentCasaItalianaBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCasaItalianaBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val categoriesFragments = arrayListOf<Fragment>(
            CIAllCategory(),
            CIChairsCategory(),
            CIDecorsCategory(),
            CISofasCategory(),
            CITablesCategory()
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

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_casaItalianaFragment_to_homeFragment)
        }
    }

}