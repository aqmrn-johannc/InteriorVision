package com.example.interiorvisioniv.fragments.stores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.adapters.HomeViewPagerAdapter
import com.example.interiorvisioniv.databinding.ActivityLoginRegisterBinding
import com.example.interiorvisioniv.databinding.FragmentCasaItalianaBinding
import com.example.interiorvisioniv.fragments.stores.categories.AllCategory
import com.example.interiorvisioniv.fragments.stores.categories.ChairsCategory
import com.example.interiorvisioniv.fragments.stores.categories.DecorsCategory
import com.example.interiorvisioniv.fragments.stores.categories.OttomansCategory
import com.example.interiorvisioniv.fragments.stores.categories.SofasCategory
import com.example.interiorvisioniv.fragments.stores.categories.TablesCategory
import com.google.android.material.tabs.TabLayoutMediator

class CasaItalianaFragment : Fragment(R.layout.fragment_casa_italiana) {

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
            AllCategory(),
            ChairsCategory(),
            DecorsCategory(),
            OttomansCategory(),
            SofasCategory(),
            TablesCategory()
        )

        val viewPager2Adapter =
            HomeViewPagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab,position ->
            when(position){
                0 -> tab.text = "All"
                1 -> tab.text = "Chairs"
                2 -> tab.text = "Decors"
                3 -> tab.text = "Ottomans"
                4 -> tab.text = "Sofas"
                5 -> tab.text = "Tables"
            }
        }.attach()
    }

}