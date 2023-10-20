package com.example.interiorvisioniv.fragments.shop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.activities.LoginRegisterActivity
import com.example.interiorvisioniv.activities.ShopActivity
import com.example.interiorvisioniv.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    private lateinit var sp: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sp = requireContext().getSharedPreferences("Data", Context.MODE_PRIVATE)
        editor = sp.edit()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgLogOut.setOnClickListener{
            editor.clear()
            editor.putBoolean("isLoggedIn", false)
            editor.apply()
            var intent = Intent(requireActivity(), LoginRegisterActivity::class.java)
            startActivity(intent)
        }

        binding.aboutUsButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_aboutUsFragment)
        }

        binding.helpCentreButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_helpCenterFragment)
        }
    }
}