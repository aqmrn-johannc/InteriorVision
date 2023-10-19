package com.example.interiorvisioniv.fragments.obscreens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_third, container, false)

        val finish = view.findViewById<Button>(R.id.bt_finish)

        finish.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_accountOptionsFragment)
            onBoardingIsFinished()
        }

        return view
    }

    private fun onBoardingIsFinished(){

        val sharedPreferences= requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("finished", true)
        editor.apply()
    }
}